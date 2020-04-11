package com.jjw.springboot;

import com.jjw.springboot.util.JedisUtils;
import com.jjw.springboot.util.RadPackageUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringbootApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private JedisUtils jedisUtils;

    @Test
    public void getTest() {


    }
}
