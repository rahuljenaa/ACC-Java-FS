package com.accenture.ltt.controller;

import org.accenture.lkm.service.CustomerService;
/*
 * POA 1: Write the respective annotation to mark the class as a Controller class 
 * 		  The annotation should also make this class as a Spring Managed Bean
 * 		  The annotation should also make sure that all the occurrences of @GetMapping/@PutMapping/@PostMapping methods assume @ResponseBody semantics by default.    
 */
public class CustomerController {

	/*
	 * POA 2: Write the respective annotation to inject the CustomerService implementation class object
	 */
	private CustomerService customerService;
	
	/*
	 * POA 3: Create a Method that executes for the URL customer/controller/getCustomerByCustomerType/Gold with GET HTTP VERB
	 * The method should return a JSON of CustomerBean if customers with given type(Gold) is found with HTTP status OK
	 * else
	 * method should return HTTP status as NOT_FOUND
	 * 
	 * Hint : Invoke the customerService.findByCustomerType(String customerType) method to get the List<CustomerBean> with given CustomerType
	 */

}
