package com.hucode.study.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Fang on 17/6/7.
 */

@Component
@RabbitListener(queues = "topic.A")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("topic Receiver1 : " + message);
    }
}
