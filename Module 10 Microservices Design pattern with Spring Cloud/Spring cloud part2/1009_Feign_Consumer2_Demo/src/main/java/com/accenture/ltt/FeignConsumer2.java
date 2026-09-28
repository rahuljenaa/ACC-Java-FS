package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignConsumer2 {

	public static void main(String[] args){
		SpringApplication.run(FeignConsumer2.class, args);
	}
}