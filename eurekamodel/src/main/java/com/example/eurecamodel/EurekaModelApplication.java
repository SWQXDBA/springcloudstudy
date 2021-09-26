package com.example.eurecamodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaModelApplication.class, args);
    }

}
