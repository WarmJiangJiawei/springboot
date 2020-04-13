package com.jjw.springboot.service;


import com.jjw.springboot.bean.CompanyMemberAuth;
import com.jjw.springboot.common.CommonResult;
import com.jjw.springboot.dto.CountScore;

import java.util.List;

public interface CompanyMemberService {
    CommonResult login(String mobile, String code, String password, Byte type);

    CommonResult check(String mobile, String password);

    CompanyMemberAuth getUserByMid(Integer userId);

    List<CountScore> coutScore();
}
