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
Access the below URL in the browser :
	http://localhost:8090/customer/controller/getCustomerByBillAmount/10000

Access the below URL in the POSTMAN client with PUT HTTP verb :
	http://localhost:8090/customer/controller/updateCustomer
Request body: Input the below JSON data.
{
"customerName":"Jack",
"billAmount":12000
}
*/