package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoadBalancerProducer {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalancerProducer.class, args);
    }
}
