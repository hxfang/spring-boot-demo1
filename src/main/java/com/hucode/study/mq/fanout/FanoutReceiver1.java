package com.hucode.study.mq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Fang on 17/6/7.
 */

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiver1 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver1 : " + message);
    }
}
