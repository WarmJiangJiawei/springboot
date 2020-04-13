package com.jjw.springboot.component;

import com.jjw.springboot.dto.CountScore;
import com.jjw.springboot.service.CompanyMemberService;
import com.jjw.springboot.util.JedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CountScoreTask {

    private Logger log = LoggerFactory.getLogger(CountScoreTask.class);

    @Autowired
    private JedisUtils jedisUtils;

    @Autowired
    private CompanyMemberService companyMemberService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void coutScore(){
        log.info("启动统计积分----------------->");
        long start = System.currentTimeMillis();
        Jedis resource = jedisUtils.getResource();
        if (resource.zcard("user:rank") != 0) {
            resource.del("user:rank");
        }
        List<CountScore> countScores = companyMemberService.coutScore();
        Map<String, Double> collect = countScores.stream().collect(Collectors.toMap(CountScore::getId, CountScore::getScore));
        resource.zadd("user:rank", collect);
        long end = System.currentTimeMillis();
        log.info("统计积分完成----------------->");
        log.info("共耗时" + (end - start) + "ms");
    }
}
