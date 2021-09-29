package com.example.springcloudstudy;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
/*import com.netflix.loadbalancer.IRule;*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@EnableFeignClients //启用Feign
//@EnableEurekaClient
@SpringBootApplication
public class SpringcloudstudyApplication {

/*
    //修改负载均衡规则
    @Bean
    public IRule getRule(){
        return new NacosRule();
    }
*/

/*    @Bean
    @LoadBalanced//用Eureka负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudstudyApplication.class, args);

    }

}
