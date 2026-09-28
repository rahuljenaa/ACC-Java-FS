package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:org/accenture/ltt/resources/cst-main-config.xml")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
}

/*
Deploy the application using maven goal : clean package spring-boot:run
Access the below URL in the browser :
	GET:
	http://localhost:8090/customer/controller/getCustomerByCustomerType/Platnium
	http://localhost:8090/customer/controller/findByBillAmountBetween/34000--85000
	
	POST:
	http://localhost:8090/customer/controller/addCustomer
	Request Body:
	{
    	"customerName": "Joseph",
    	"customerType": "Gold",
    	"billAmount": 56000.0
	}
	http://localhost:8090/customer/controller/addCustomer
	Request Body:
	{
    	"customerType": "Xyz",
    	"billAmount": 56.0
	}
	
	PUT:
	http://localhost:8090/customer/controller/updateCustomer/1001
	Request Body:
	{
    	"customerName": "Joseph",
    	"customerType": "Gold",
    	"billAmount": 56000.0
	}	
	http://localhost:8090/customer/controller/updateCustomer/11
	Request Body:
	{
    	"customerName": "XYZ",
    	"customerType": "Gold",
    	"billAmount": 56000.0
	}
*/