package com.jjw.springboot.config;

import com.jjw.springboot.annotation.NeedToken;
import com.jjw.springboot.annotation.PassToken;
import com.jjw.springboot.bean.CompanyMemberAuth;
import com.jjw.springboot.service.CompanyMemberService;
import com.jjw.springboot.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

@EnableConfigurationProperties(JwtProperties.class)
public class AuthenticationInterceptor implements HandlerInterceptor{

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CompanyMemberService companyMemberService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.addHeader("Access-Control-Allow-Headers",
//                "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,token");
        String token = request.getHeader("Bearer");// 从 http 请求头中取出 token
        System.out.println(token);
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(NeedToken.class)) {
            NeedToken userLoginToken = method.getAnnotation(NeedToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }

                // 获取 token 中的 user id
                Map<String, Object> infoFromToken = null;
                try {
                     infoFromToken = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
                } catch (Exception j) {
                    j.printStackTrace();
                }
                Integer userId = (Integer) infoFromToken.get("id");

                CompanyMemberAuth companyMemberAuth = companyMemberService.getUserByMid(userId);

                Object token1 = redisTemplate.opsForHash().get("token", "member:" + companyMemberAuth.getUsername() + ":" + companyMemberAuth.getMid());
                if (!token.equals(token1)) {
                    throw new RuntimeException("token被修改");
                }
                if (companyMemberAuth == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }

                // 验证 token
                Integer expire = (Integer) infoFromToken.get("exp");
                if (expire < System.currentTimeMillis()/1000){
                    throw new RuntimeException("token过期");
                }

                return true;
            }
        }
        return true;
    }
}
