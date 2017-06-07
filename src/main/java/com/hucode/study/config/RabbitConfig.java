package com.hucode.study.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Fang on 17/6/5.
 */
@Configuration
@Profile("home")
public class RabbitConfig {

    final static String queueTest = "test";

    @Bean
    public Queue QueueTest() {
        return new Queue(queueTest);
    }

    @Bean
    public Queue queueTopicA() {
        return new Queue("topic.A");
    }

    @Bean
    public Queue queueTopicB() {
        return new Queue("topic.B");
    }

    @Bean
    public Queue queueFanoutA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue queueFanoutB() {
        return new Queue("fanout.B");
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeTopicB(Queue queueTopicB, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicB).to(topicExchange).with("topic.B");
    }

    @Bean
    Binding bindingExchangeTopicAll(Queue queueTopicA, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicA).to(topicExchange).with("topic.#");
    }

    @Bean
    Binding bindingExchangeFanoutA(Queue queueFanoutA,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFanoutA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeFanoutB(Queue queueFanoutB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFanoutB).to(fanoutExchange);
    }


}
