package com.example.rabbitmqpublisher;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;


@SpringBootApplication
public class RabbitmqpublisherApplication {

    //自定义序列化转换器类型用jackson
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqpublisherApplication.class, args);
    }

}
