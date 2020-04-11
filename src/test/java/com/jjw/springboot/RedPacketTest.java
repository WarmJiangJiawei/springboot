package com.jjw.springboot;

import com.jjw.springboot.common.CommonResult;
import com.jjw.springboot.controller.RedBucketController;
import com.jjw.springboot.util.JedisUtils;
import com.jjw.springboot.util.RadPackageUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = SpringbootApplication.class)
@RunWith(SpringRunner.class)
public class RedPacketTest {

    @Autowired
    private JedisUtils jedisUtils;

    @Test
    public void general() throws IOException {
        List<Integer> aPackage = RadPackageUtils.getPackage(10, 10);
        List<String> collect = aPackage.stream().map(itme -> {
            return itme.toString();
        }).collect(Collectors.toList());
        jedisUtils.lpush("red:list", collect.toArray(new String[]{}));
    }

}
