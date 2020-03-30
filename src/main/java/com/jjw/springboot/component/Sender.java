package com.jjw.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private static Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("enjoy", message);
        logger.info("生产者发送------>" + message);
    }

}
