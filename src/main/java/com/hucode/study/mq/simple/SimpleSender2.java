package com.hucode.study.mq.simple;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Fang on 17/6/5.
 */

@Component
@Profile("home")
public class SimpleSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "--test2-- " + new Date();
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("test", context);
    }

    public void send(Integer index) {
        String context = "--test2-- <" + index.toString() + ">";
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("test", context);
    }
}
