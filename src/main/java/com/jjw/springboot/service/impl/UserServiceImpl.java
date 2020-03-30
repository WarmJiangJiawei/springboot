package com.jjw.springboot.service.impl;

import com.jjw.springboot.bean.User;
import com.jjw.springboot.dao.UserDao;
import com.jjw.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUser(Integer id) {
        return userDao.get(id);
    }
}
