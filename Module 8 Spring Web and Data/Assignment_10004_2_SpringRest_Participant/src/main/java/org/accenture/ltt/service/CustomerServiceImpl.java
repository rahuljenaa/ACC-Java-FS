package org.accenture.ltt.service;

import java.util.List;

import org.accenture.ltt.business.bean.CustomerBean;
import org.accenture.ltt.dao.CustomerDAOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAOWrapper customerDAOWrapper;
	
	@Override
	public List<CustomerBean> findByCustomerType(String customerType) {
		return customerDAOWrapper.findByCustomerType(customerType);
	}

	@Override
	public List<CustomerBean> findByBillAmountBetween(double minBillAmount, double maxBillAmount) {
		return customerDAOWrapper.findByBillAmountBetween(minBillAmount, maxBillAmount);
	}

	@Override
	public CustomerBean save(CustomerBean customerBean) {
		return customerDAOWrapper.save(customerBean);
	}

	@Override
	public CustomerBean findById(Integer customerId) {
		return customerDAOWrapper.findById(customerId);
	}

	
}
