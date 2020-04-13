package com.jjw.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jjw.springboot.bean.CompanyMemberAuth;
import com.jjw.springboot.common.CommonResult;
import com.jjw.springboot.config.JwtProperties;
import com.jjw.springboot.dao.CompanyMemberAuthMapper;
import com.jjw.springboot.dao.CompanyMemberMapper;
import com.jjw.springboot.dto.CountScore;
import com.jjw.springboot.service.CompanyMemberService;
import com.jjw.springboot.util.JwtUtils;
import com.jjw.springboot.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class CompanyMemberServiceImpl implements CompanyMemberService {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private CompanyMemberMapper companyMemberMapper;

    @Autowired
    private CompanyMemberAuthMapper companyMemberAuthMapper;

    @Override
    public CommonResult login(String mobile, String code, String password, Byte type) {
       //查找账号是否存在
        QueryWrapper<CompanyMemberAuth> wrapper = new QueryWrapper<>();
        wrapper.eq("username", mobile);
        CompanyMemberAuth companyMemberAuth = companyMemberAuthMapper.selectOne(wrapper);
        if (companyMemberAuth == null) {
            return CommonResult.failed("没有该用户");
        }else if (companyMemberAuth.getStatus() == 0) {
            return CommonResult.failed("用户已禁用");
        }

        if (!MD5Utils.GetMD5Code(password + companyMemberAuth.getSalt()).equals(companyMemberAuth.getPassword())) {
            return CommonResult.failed("密码错误");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", companyMemberAuth.getMid());
        String token = null;
        try {
             token = JwtUtils.generateToken(map, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("token", token);
        stringRedisTemplate.opsForHash().put("token", "member:"+ companyMemberAuth.getUsername() + ":" + companyMemberAuth.getMid(), token);
        return CommonResult.success(map);
    }

    @Override
    public CommonResult check(String mobile, String password) {

        return CommonResult.success("hhh");

    }

    @Override
    public CompanyMemberAuth getUserByMid(Integer userId) {
        QueryWrapper<CompanyMemberAuth> wrapper = new QueryWrapper<>();
        wrapper.eq("mid", userId);
        return companyMemberAuthMapper.selectOne(wrapper);
    }

    //统计积分
    public List<CountScore> coutScore(){
        List<CountScore> countScores = companyMemberMapper.countScore();
        return countScores;
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean compareSmsCode(String mobile, String code) {
        String res = stringRedisTemplate.opsForValue().get("user" + mobile);
        if (code.equals(res)) {
            return true;
        }
        return false;
    }
}
