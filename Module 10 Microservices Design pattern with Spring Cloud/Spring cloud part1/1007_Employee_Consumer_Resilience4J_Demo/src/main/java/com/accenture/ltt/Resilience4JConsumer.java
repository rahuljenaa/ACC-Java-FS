package com.accenture.ltt;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class Resilience4JConsumer {

    public static void main(String[] args) throws RestClientException, IOException {
    	SpringApplication.run(Resilience4JConsumer.class, args);
    }   
}