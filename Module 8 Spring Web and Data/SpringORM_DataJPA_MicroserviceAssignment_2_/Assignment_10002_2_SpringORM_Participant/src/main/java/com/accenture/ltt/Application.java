package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:com/accenture/ltt/resources/cst-main-config.xml")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
}

/*
Deploy the application using maven goal : clean package spring-boot:run
1.
Access the below URL in the POSTMAN with POST http VERB :
	http://localhost:8090/customer/controller/addCustomer

in the request body, enter the below:
{
	"customerName":"John",
	"billAmount":120000
}

2. 
Access the below URL in the POSTMAN with PUT http VERB :
	http://localhost:8090/customer/controller/updateCustomer
	
in the request body, enter the below:
{
	"customerId":1001,
	"billAmount":12000
}
*/