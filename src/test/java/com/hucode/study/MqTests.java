package com.hucode.study;


import com.hucode.study.mq.fanout.FanoutSender;
import com.hucode.study.mq.simple.SimpleSender1;
import com.hucode.study.mq.simple.SimpleSender2;
import com.hucode.study.mq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Fang on 17/6/5.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTests {

    @Autowired
    private SimpleSender1 simpleSender1;
    @Autowired
    private SimpleSender2 simpleSender2;

    @Autowired
    private TopicSender topicSender;


    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void one() throws Exception {
        simpleSender1.send();
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i = 1; i <= 20; i++){
            simpleSender1.send(i);
        }
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i = 1; i <= 20; i++){
            simpleSender1.send(i);
            simpleSender2.send(i);
        }
    }

    @Test
    public void topic1() throws Exception {
        topicSender.sendB();
    }

    @Test
    public void topic2() throws Exception {
        topicSender.sendAll();
    }

    @Test
    public void fanoutSender() throws Exception {
        fanoutSender.send();
    }
}
