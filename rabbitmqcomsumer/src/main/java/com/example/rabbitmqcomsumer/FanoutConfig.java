package com.example.rabbitmqcomsumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutConfig {
    //FanoutExchange相当于发布订阅模式 发布的消息会给所有绑定的队列
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("exchange1");
    }
    @Bean
    public Queue queue1(){
        return new Queue("queue1");
    }
    @Bean
    public Queue queue2(){
        return new Queue("queue2");
    }
    @Bean
    public Queue objectQueue(){
        return new Queue("objectQueue");
    }
    ///@Bean后传入的参数可以根据名字注入Bean

    //绑定队列1到交换机
    @Bean
    public Binding binding1(Queue queue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }
    //绑定队列2到交换机
    @Bean
    public Binding binding2(Queue queue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }
}
