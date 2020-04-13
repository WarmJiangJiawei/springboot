package com.jjw.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjw.springboot.bean.CompanyMember;
import com.jjw.springboot.dto.CountScore;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CompanyMemberMapper extends BaseMapper<CompanyMember> {

    @Select("SELECT\n" +
            "id,score\n" +
            "FROM\n" +
            "`company_member`\n" +
            "WHERE\n" +
            "`status` = 1\n" +
            "ORDER BY\n" +
            "score\n" +
            "LIMIT 50")
    List<CountScore> countScore();
}
