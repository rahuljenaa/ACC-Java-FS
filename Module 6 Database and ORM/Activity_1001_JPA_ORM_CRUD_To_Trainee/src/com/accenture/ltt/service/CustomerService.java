package com.accenture.ltt.service;

import java.util.Date;
import java.util.List;

import com.accenture.ltt.businessbean.CustomerBean;

public interface CustomerService {
	Integer addCustomer(CustomerBean customer) throws Exception;
	CustomerBean findCustomerById(Integer customerId) throws Exception;
	CustomerBean updateCustomerBillById(CustomerBean customerBean)throws Exception;
	CustomerBean deleteCustomerById(Integer customerId) throws Exception;
	// JPQL
	List<CustomerBean> getCustomersWithinDateRange(Date lowerBound,Date upperBound) throws Exception;
	Integer updateCustomerBillByName(String name, Double bill)throws Exception;
}
