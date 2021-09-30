package com.example.gatewaymodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewaymodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaymodelApplication.class, args);
    }

}
