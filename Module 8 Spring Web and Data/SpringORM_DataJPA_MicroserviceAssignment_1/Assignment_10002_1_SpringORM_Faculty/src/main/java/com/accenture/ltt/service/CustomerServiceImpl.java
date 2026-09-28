package com.accenture.ltt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public Integer addCustomer(CustomerBean customerBean) {
		return customerDAO.addCustomer(customerBean);
	}
}
