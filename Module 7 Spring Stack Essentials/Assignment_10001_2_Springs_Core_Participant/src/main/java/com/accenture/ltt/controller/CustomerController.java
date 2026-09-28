package com.accenture.ltt.controller;

import org.accenture.lkm.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	@Qualifier("customer1")
	private Customer customer;
	
	@GetMapping(value = "customer/controller/getCustomer",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(){
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

}
