package com.accenture.ltt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.business.bean.OrderBean;
import com.accenture.ltt.service.OrderService;

/*
 * POA 5: Write the respective annotation to mark the class as a Controller class 
 * 		  The annotation should also make this class as a Spring Managed Bean
 * 		  The annotation should also make sure that all the occurrences of @GetMapping/@PutMapping/@PostMapping methods assume @ResponseBody semantics by default.    
 */
public class OrderController {

	/*
	 * POA 6: Write the respective annotation to inject the CustomerService implementation class object
	 */
	private OrderService orderService;
	
	/*
	 * POA 7: Create a Method that executes for the URL order/controller/addOrder with POST HTTP VERB
	 * It should accept the JSON in the Request body and de-serialize it to OrderBean
	 * It should validate the OrderBean and if in case of any validation errors then return complete error messages with HTTP status BAD_REQUEST
	 * else
	 * It should invoke the appropriate method from OrderService class to save the OrderBean and return the Message "Order Added Successfully with OrderId :<<orderId>>"
	 * 
	 * Hint : Invoke the orderService.save(OrderBean customerBean) method to save the object
	 */
	
	
}
