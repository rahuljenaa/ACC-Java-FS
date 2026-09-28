package com.accenture.ltt.controller;

import org.accenture.ltt.service.CustomerService;

/*
 * POA 3: Write the respective annotation to mark the class as a Controller class 
 * 		  The annotation should also make this class as a Spring Managed Bean
 * 		  The annotation should also make sure that all the occurrences of @GetMapping/@PutMapping/@PostMapping methods assume @ResponseBody semantics by default.    
 */
public class CustomerController {

	/*
	 * POA 4: Write the respective annotation to inject the CustomerService implementation class object
	 */
	private CustomerService customerService;

	/*
	 * POA 5: Create a Method that executes for the URL customer/controller/getCustomerByCustomerType/Platinum with GET HTTP VERB
	 * The method should return a JSON of CustomerBean if customers with given type(Platnium) is found with HTTP status OK
	 * else
	 * method should return HTTP status as NOT_FOUND
	 * 
	 * Hint : Invoke the customerService.findByCustomerType(String customerType) method to get the List<CustomerBean> with given CustomerType
	 */
	
	/*
	 * POA 6: Create a Method that executes for the URL customer/controller/findByBillAmountBetween/34000--85000 with GET HTTP VERB
	 * The method should return a JSON of CustomerBean if customers within given billAmount(34000--85000) is found with HTTP status OK
	 * else
	 * method should return HTTP status as NOT_FOUND
	 * 
	 * Hint : Invoke the customerService.findByBillAmountBetween(double minBillAmount, double maxBillAmount) method to get the List<CustomerBean> within given bill amount
	 */
	
	/*
	 * POA 7: Create a Method that executes for the URL customer/controller/addCustomer with POST HTTP VERB
	 * It should accept the JSON in the Request body and de-serialize it to CustomerBean
	 * It should validate the CustomerBean and if in case of any validation errors then return complete error messages with HTTP status BAD_REQUEST
	 * else
	 * It should invoke the appropriate method from CustomerService class to save the CustomerBean and return the Message "Customer Added Successfully with CustomerId :<<customerId>>"
	 * 
	 * Hint : Invoke the customerService.save(CustomerBean customerBean) method to save the object
	 */
	
	/*
	 * POA 8: Create a Method that executes for the URL customer/controller/updateCustomer/1001 with PUT HTTP VERB
	 * It should also accept the JSON in the Request body and de-serialize it to CustomerBean
	 * It should invoke the appropriate method from CustomerService class to check if the Customer with given CustomerId(1001) exists in DB or not
	 * If exists it should update the existing Customer details with de-serialized CustomerBean received in request body and return message as "Customer Record update Successfully" with HTTP status OK
	 * else
	 * return message as "Customer with given id doesn't exists to update" with HTTP status NOT_FOUND
	 * 
	 * Hint : Invoke the customerService.findById(Integer customerId) to check if customer exists or not 
	 * 		  Invoke customerService.save(CustomerBean customerBean) to update the customer details
	 * 	
	 */
	
}
