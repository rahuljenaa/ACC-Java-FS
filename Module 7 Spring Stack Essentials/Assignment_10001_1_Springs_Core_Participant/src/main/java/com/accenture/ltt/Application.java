package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"org/accenture/ltt/resources/my_springbean.xml"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
}
/*
Deploy the application using maven goal : clean package spring-boot:run
Access the below URL in the browser :
	http://localhost:8090/customer/controller/getCustomer
Stop the deployment 
	
*/