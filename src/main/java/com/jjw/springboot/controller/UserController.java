package com.jjw.springboot.controller;

import com.jjw.springboot.bean.User;
import com.jjw.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        logger.info("id is ----->" + id);
        return userService.getUser(id);
    }
}
