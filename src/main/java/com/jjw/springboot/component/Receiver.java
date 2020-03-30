package com.jjw.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "enjoy")
public class Receiver {
    private static Logger logger = LoggerFactory.getLogger(Sender.class);

    @RabbitHandler
    public void handle(String message) {
        System.out.println(message);
        logger.info("消费者接收到<------" + message);
    }
}
