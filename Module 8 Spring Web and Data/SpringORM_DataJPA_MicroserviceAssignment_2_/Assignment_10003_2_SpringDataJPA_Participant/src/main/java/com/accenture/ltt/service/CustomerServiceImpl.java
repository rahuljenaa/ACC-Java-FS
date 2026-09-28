package com.accenture.ltt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.dao.CustomerDAOWrapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAOWrapper customerDAOWrapper;

	@Override
	public List<CustomerBean> getCustomerByBillAmount(double amount) {
		return customerDAOWrapper.getCustomerByBillAmount(amount);
	}

	@Override
	public Integer updateCustomerDetails(CustomerBean customerBean) {
		return customerDAOWrapper.updateCustomerDetails(assignCustomerType(customerBean));
	}
	
	private CustomerBean assignCustomerType(CustomerBean customerBean) {
		double billAmount = customerBean.getBillAmount();
		
		/*
		 * POA 14 : complete the code to set the customerType based on billAmount as follows:
		 * billAmount (1000 - 5000)		---> customerType (S)
		 * billAmount (5001 - 10000)	---> customerType (G)
		 * billAmount (10001 - 15000)	---> customerType (P)
		 * billAmount (>= 15001)		---> customerType (D)
		 * else							---> customerType (-)
		 */

		return customerBean;
	}
}
