package com.jjw.springboot.service;


import com.jjw.springboot.bean.CompanyMemberAuth;
import com.jjw.springboot.common.CommonResult;

public interface CompanyMemberService {
    CommonResult login(String mobile, String code, String password, Byte type);

    CommonResult check(String mobile, String password);

    CompanyMemberAuth getUserByMid(Integer userId);
}
