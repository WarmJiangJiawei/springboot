package com.jjw.springboot.controller;

import com.jjw.springboot.common.CommonResult;
import com.jjw.springboot.util.JedisUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("/redbucket")
public class RedBucketController {

    @Autowired
    private JedisUtils jedisUtils;

    @PostMapping("/get")
    public CommonResult get(@RequestParam("id") Integer id) throws IOException {

        Jedis jedis = jedisUtils.getResource();
        Boolean used = jedis.hexists("used" + id.toString(), "id");
        if (used) {
            return CommonResult.failed("你已经抢过啦");
        }else {
            String lpop = jedis.lpop("red:list");
            if (lpop != null) {
                Map<String,String> map = new HashMap<>();
                map.put("id", id.toString());
                map.put("money", lpop);
                map.put("time", String.valueOf(System.currentTimeMillis()));
                jedis.hmset("used"+id.toString(), map);
                return CommonResult.success("你获得了" + lpop + "yuan");
            }
            return CommonResult.success("你来晚了");
        }
    }
}
