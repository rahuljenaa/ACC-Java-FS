package com.accenture.ltt.controller;

import com.accenture.ltt.service.OrderService;

/*
 * POA 12: Write the respective annotation to mark the class as a Controller class 
 * 		  The annotation should also make this class as a Spring Managed Bean
 * 		  The annotation should also make sure that all the occurrences of @GetMapping/@PutMapping/@PostMapping methods assume @ResponseBody semantics by default.    
 */
public class OrderController {

	/*
	 * POA 13: Write the respective annotation to inject the CustomerService implementation class object
	 */
	private OrderService orderService;
	
	/*
	 * POA 14: Create a Method that executes for the URL order/controller/addOrder with POST HTTP VERB
	 * It should accept the JSON in the Request body and de-serialize it to OrderBean
	 * It should validate the OrderBean and if in case of any validation errors then return complete error messages with HTTP status BAD_REQUEST
	 * else
	 * It should invoke the appropriate method from OrderService class to save the OrderBean and return the Message "Order Added Successfully with OrderId :<<orderId>>"
	 * 
	 * Hint : Invoke the orderService.save(OrderBean customerBean) method to save the object
	 */
	
	
	/*
	 * POA 15: Create a Method that executes for the URL order/controller/getOrdersInBillingRange/56000--90000 with GET HTTP VERB
	 * It should invoke the appropriate method from OrderService class to get a List of Orders within given billRange(56000--90000) 
	 * If  the List returned is not null return the same with HTTP status OK
	 * else
	 * method should return HTTP status as NOT_FOUND
	 * 
	 * Hint : Invoke the orderService.getOrdersInBillingRange(double minBillAmount, double maxBillAmount) method to get the List<OrderBean> within given bill range
	 */
	
	
	/*
	 * POA 16: Create a Method that executes for the URL order/controller/updateOrderStatus with PUT HTTP VERB
	 * It should accept the JSON in the Request body and de-serialize it to orderBean
	 * It should also validate the OrderBean and if in case of any validation errors then return complete error messages with HTTP status BAD_REQUEST
	 * else
	 * It should invoke the appropriate method from OrderService class to update the Orderstatus
	 * If the method invoked form OrderService class returns true then return message as "Order status updated succesfully" with HTTP status OK
	 * else
	 * return HTTP status INTERNAL_SERVER_ERROR
	 * 
	 * Hint : Invoke the orderService.updateOrderStatus(OrderBean orderBean) to update the order status on validation success 
	 * 	
	 */

	
	/*
	 * POA 17: Create a Method that executes for the URL order/controller/deleteOrder/1001 with DELETE HTTP VERB
	 * It should invoke the appropriate method from OrderService class to delete the order with the given orderId
	 * If deletion is successfull returns the orderBean JSON with HTTP status as OK
	 * else
	 * return HTTP status INTERNAL_SERVER_ERROR
	 * 
	 * Hint : Invoke the orderService.deleteOrder(Integer orderId) to delete the order
	 * 	
	 */

}
