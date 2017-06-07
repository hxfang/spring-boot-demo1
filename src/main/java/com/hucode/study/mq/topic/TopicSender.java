package com.hucode.study.mq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Fang on 17/6/7.
 */

@Component
@Profile("home")
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendB() {
        String context = "message B";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.B", context);
    }

    public void sendAll() {
        String context = "messages All";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.#", context);
    }
}
