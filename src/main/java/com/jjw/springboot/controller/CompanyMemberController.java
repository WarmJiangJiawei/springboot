package com.jjw.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jjw.springboot.annotation.NeedToken;
import com.jjw.springboot.common.CommonResult;
import com.jjw.springboot.service.CompanyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ums/member")
public class CompanyMemberController {

    @Autowired
    private CompanyMemberService companyMemberService;

    @PostMapping("/login")
    public CommonResult<Map> login(@RequestParam String mobile,
                                   @RequestParam String code,
                                   @RequestParam String password,
                                   @RequestParam Byte type,
                                   HttpServletResponse request){
        CommonResult commonResult = companyMemberService.login(mobile, code, password, type);
        String data = commonResult.getData().toString();
        System.out.println(data.split(",")[2].split("=")[1]);
        request.setHeader("Bearer", data.split(",")[2].split("=")[1]);
        System.out.println(request.getHeader("Bearer"));
        return commonResult;
    }

    @NeedToken
    @PostMapping("/check")
    public CommonResult check(@RequestParam String mobile,
                              @RequestParam String password){
        CommonResult commonResult = companyMemberService.check(mobile, password);
        return commonResult;
    }

}
