package com.jjw.springboot.util;

import com.jjw.springboot.config.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;


@Component
public class RedisUtil {

    private static final Logger log = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private JedisPool jedisPool;
}
