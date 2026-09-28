package com.accenture.ltt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(value = "customer/controller/addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addCustomer(@RequestBody CustomerBean customerBean) {
		Integer customerId = customerService.addCustomer(customerBean);
		return new ResponseEntity<String>("Customer added successfully " + customerId, HttpStatus.CREATED);
	}
}
