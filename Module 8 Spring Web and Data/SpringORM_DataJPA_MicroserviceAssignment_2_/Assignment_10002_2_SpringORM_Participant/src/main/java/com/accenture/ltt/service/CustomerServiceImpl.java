package com.accenture.ltt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.dao.CustomerDAO;

/*
 * POA 11 : Annotate with required annotation to make this class a spring managed bean  
 */
public class CustomerServiceImpl implements CustomerService {

	/*
	 * POA 12 : Write the required annotation to inject 
	 */
	private CustomerDAO customerDAO;

	public Integer addCustomer(CustomerBean customerBean) {
		return customerDAO.addCustomer(assignCustomerType(customerBean));
	}

	private CustomerBean assignCustomerType(CustomerBean customerBean) {
		double billAmount = customerBean.getBillAmount();

		/*
		 * POA 13 : complete the code to set the customerType based on billAmount as follows:
		 * billAmount (1000 - 5000)		---> customerType (S)
		 * billAmount (5001 - 10000)	---> customerType (G)
		 * billAmount (10001 - 15000)	---> customerType (P)
		 * billAmount (>= 15001)		---> customerType (D)
		 * else							---> customerType (-)
		 */
		
		return customerBean;
	}

	public CustomerBean updateCustomerDetails(CustomerBean customerBean) {
		return customerDAO.updateCustomerDetails(assignCustomerType(customerBean));
	}
}
