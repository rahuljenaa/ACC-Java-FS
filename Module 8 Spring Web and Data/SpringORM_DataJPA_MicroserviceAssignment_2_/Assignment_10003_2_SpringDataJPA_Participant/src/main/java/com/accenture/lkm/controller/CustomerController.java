package com.accenture.lkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "customer/controller/getCustomerByBillAmount/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerBean>> getCustomerByBillAmount(@PathVariable("amount") double amount) {
		List<CustomerBean> customerBeans = customerService.getCustomerByBillAmount(amount);
		if (customerBeans != null)
			return new ResponseEntity<List<CustomerBean>>(customerBeans, HttpStatus.OK);
		else
			return new ResponseEntity<List<CustomerBean>>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "customer/controller/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerBean customerBean) {
		Integer count = customerService.updateCustomerDetails(customerBean);
		if (count > 0)
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
}
