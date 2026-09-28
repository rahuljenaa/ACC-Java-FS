package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
/*
 * POA 20: Annotate the class with required annotation so that it becomes a Spring Boot primary configuration class,
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
	GET:
	http://localhost:8090/order/controller/getOrdersInBillingRange/80000--90000
	
	POST:
	http://localhost:8090/order/controller/addOrder
	Request Body:
	{
	    "status":"CONFIRMED",
	    "productName":"Jabra-Headset",
	    "quantity":1,
	    "billAmount":4500
	}
	http://localhost:8090/order/controller/addOrder
	Request Body:
	{
	    "status":"Ordered",
	    "quantity":15
	}
	
	PUT:
	http://localhost:8090/order/controller/updateOrderStatus
	Request Body:
	{
	    "orderId": 1001,
	    "status": "Delivered",
	    "productName": "HP-Laptop",
	    "quantity": 1,
	    "billAmount": 82000.0
	}
	http://localhost:8090/order/controller/updateOrderStatus
	Request Body:
	{
	    "orderId": 1001,
	    "status": "Ordered",
	    "quantity": 15
	}	
	DELETE:
	http://localhost:8090/order/controller/deleteOrder/1005
*/