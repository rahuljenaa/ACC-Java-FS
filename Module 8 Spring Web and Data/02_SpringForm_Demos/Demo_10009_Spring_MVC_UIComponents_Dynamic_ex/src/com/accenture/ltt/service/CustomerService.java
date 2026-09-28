package com.accenture.ltt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.dao.CustomerDAO;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDAO dao;
	
	
	public Map<String, String> getCustomerType() {
		return dao.getCustomerType();
	}
	
	
	public List<String> getCustomerTypeSameValueAndLabel() {
		return dao.getCustomerTypeSameValueAndLabel();
	}

	
	public Map<String, String> getCustomerServices() {
		return dao.getCustomerServices();
	}
	
	public Map<String, String> getGender() {
		return dao.getGender();
	}
}
