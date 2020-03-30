package com.jjw.springboot.dao;

import com.jjw.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User get(@Param("id") Integer id);
}
