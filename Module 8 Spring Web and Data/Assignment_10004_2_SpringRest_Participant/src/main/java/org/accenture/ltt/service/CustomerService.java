package org.accenture.ltt.service;

import java.util.List;

import org.accenture.ltt.business.bean.CustomerBean;

public interface CustomerService {
	List<CustomerBean> findByCustomerType(String customerType);
	List<CustomerBean> findByBillAmountBetween(double minBillAmount, double maxBillAmount);
	CustomerBean save(CustomerBean customerBean);
	CustomerBean findById(Integer customerId);
}
