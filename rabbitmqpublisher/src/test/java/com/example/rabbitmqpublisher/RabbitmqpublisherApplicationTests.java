package com.example.rabbitmqpublisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RabbitmqpublisherApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
        String queueName = "simple.queue";
        String message = "hello springMQ!";

        rabbitTemplate.convertAndSend(queueName,message);
        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //发送到交换机 让交换机上的两个队列都能接收到
    @Test
    void testsSendToExchange() {
        String exchangeName = "exchange1";
        String message = "hello exchange1!";

        rabbitTemplate.convertAndSend(exchangeName,"",message);

    }

    @Test
    void testsSendToDirectExchange() {
        String exchangeName = "direct";
        rabbitTemplate.convertAndSend(exchangeName,"key1","hello key1");
        rabbitTemplate.convertAndSend(exchangeName,"key2","hello key2");
        rabbitTemplate.convertAndSend(exchangeName,"key3","hello key3");
        rabbitTemplate.convertAndSend(exchangeName,"key4","hello key4");

    }

    @Test
    void testsSendToTopicExchange() {
        String exchangeName = "topic";
        rabbitTemplate.convertAndSend(exchangeName,"china.news","china.news");
        rabbitTemplate.convertAndSend(exchangeName,"china.key","china.key");
        rabbitTemplate.convertAndSend(exchangeName,"hello.news","hello.news");
        rabbitTemplate.convertAndSend(exchangeName,"key4","hello key4");
    }
    @Test
    void testsSendObject() {
        Map<String,Integer> map= new HashMap<>();
        map.put("你好",1);
        String queueName = "objectQueue";
        rabbitTemplate.convertAndSend(queueName,map);

    }
}
