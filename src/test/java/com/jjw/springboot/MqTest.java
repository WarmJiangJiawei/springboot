package com.jjw.springboot;

import com.jjw.springboot.component.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootApplication.class)
@RunWith(SpringRunner.class)
public class MqTest {

    @Autowired
    private Sender sender;

    @Test
    public void testMQ() {
        sender.sendMessage("hello every please enjoy it");
    }
}
