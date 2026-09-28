package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//Part of Spring Cloud Commons project
//@EnableEurekaClient
public class EurekaProducer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProducer.class, args);
    }
}



