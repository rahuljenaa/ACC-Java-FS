package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.business.bean.CustomerBean;

public interface CustomerService {
	List<CustomerBean> getCustomerByBillAmount(double amount);

	Integer updateCustomerDetails(CustomerBean customerBean);
}
