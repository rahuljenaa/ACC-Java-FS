package org.accenture.lkm.service;

import java.util.List;

import org.accenture.lkm.business.bean.CustomerBean;
import org.accenture.lkm.dao.CustomerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAOImpl customerDAOWrapper;
	
	@Override
	public List<CustomerBean> findByCustomerType(String customerType) {
		return customerDAOWrapper.findByCustomerType(customerType);
	}
}
