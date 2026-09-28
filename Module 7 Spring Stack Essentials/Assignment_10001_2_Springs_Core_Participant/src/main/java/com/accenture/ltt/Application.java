package com.accenture.ltt;

import org.accenture.lkm.resources.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ImportResource(locations = {"org/accenture/ltt/resources/my_springbean.xml"})
@Import({ MyConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
}

/*
Deploy the application using maven goal : clean package spring-boot:run
Access the below URL in the browser :
	http://localhost:8080/customer/controller/getCustomer
Stop the deployment 
	
Comment line no 10 and uncomment line no 11
Deploy the application again using maven goal : clean package spring-boot:run
Access the below URL in the browser :
	http://localhost:8080/customer/controller/getCustomer
*/