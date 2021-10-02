package com.example.rabbitmqcomsumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class comsumer {
    @RabbitListener(queues= "simple.queue")
    public void listener(String msg){
        System.out.println("接收到了队列消息 "+msg);
    }


    @RabbitListener(queues= "queue1")
    public void listener2(String msg){
        System.out.println("接收到了队列1的消息 "+msg);
    }

    @RabbitListener(queues= "queue2")
    public void listener3(String msg){
        System.out.println("接收到了队列2的消息 "+msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "direct.queue1"),//声明监听的队列名字
            exchange = @Exchange(name = "direct",type = ExchangeTypes.DIRECT),//声明队列要绑定的交换机和交换机类型
            key = {"key1","key2"}))//发送消息的时候可以设定routingKey 表示发送给匹配的队列 routingKey为这些值的 才会被接收
    public void listener4(String msg){
        System.out.println("key1 key2接收到了队列direct的消息 "+msg);
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "direct.queue2"),//声明监听的队列名字
            exchange = @Exchange(name = "direct",type = ExchangeTypes.DIRECT),//声明队列要绑定的交换机和交换机类型
            key = {"key3","key4"}))//发送消息的时候可以设定routingKey 表示发送给匹配的队列 routingKey为这些值的 才会被接收
    public void listener5(String msg){
        System.out.println("key3 key4接收到了队列direct的消息 "+msg);
    }



    //#代表0个或多个单词都行
    //*代表1个单词
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic.queue5"),//声明监听的队列名字
            exchange = @Exchange(name = "topic",type = ExchangeTypes.TOPIC),//声明队列要绑定的交换机和交换机类型
            key = "china.#"))//发送消息的时候可以设定routingKey 表示发送给匹配的队列 routingKey为这些值的 才会被接收
    public void listener6(String msg){
        System.out.println("china.#接收到了topic的消息 "+msg);
    }

    //#代表0个或多个单词都行
    //*代表1个单词
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic.queue6"),//声明监听的队列名字
            exchange = @Exchange(name = "topic",type = ExchangeTypes.TOPIC),//声明队列要绑定的交换机和交换机类型
            key = "*.news"))//发送消息的时候可以设定routingKey 表示发送给匹配的队列 routingKey为这些值的 才会被接收
    public void listener7(String msg){
        System.out.println("*.news接收到了队列接收到了topic的消息 "+msg);
    }


    @RabbitListener(queues= "objectQueue")
    public void objectListener(Map<String,Integer> map){
        System.out.println("接收到了map消息 "+map);
    }
}
