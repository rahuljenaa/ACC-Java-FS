package com.accenture.ltt.dao;

import com.accenture.ltt.business.bean.CustomerBean;

public interface CustomerDAO {

	Integer addCustomer(CustomerBean customerBean);
	CustomerBean updateCustomerDetails(CustomerBean customerBean);

}