package com.hucode.study.mq.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Fang on 17/6/5.
 */
@Component
@Profile("home")
@RabbitListener(queues = "test")
public class SimpleReceiver2 {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Received2 :" + message);
    }
}
