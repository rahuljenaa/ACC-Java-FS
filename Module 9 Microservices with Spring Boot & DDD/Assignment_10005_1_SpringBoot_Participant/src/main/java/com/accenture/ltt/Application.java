package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * POA 8: Annotate the class with required annotation so that it becomes a Spring Boot primary configuration class,
 * EnableAutoConfiguration and does component scan 
 */
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
}

/*
Deploy the application using maven goal : clean package spring-boot:run
Access the below URL in the browser :
	POST:
	http://localhost:8090/order/controller/addOrder
	Request Body:
	{
	    "status":"CONFIRMED",
	    "productName":"Jabra-Headset",
	    "quantity":1,
	    "billAmount":4500
	}
*/