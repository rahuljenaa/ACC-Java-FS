package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.entity.CustomerEntity;

/*
 * POA 10 : Annotate with required annotation to make this class a spring managed bean 
*/
public class CustomerDAOWrapper {

	/*
	 * POA 11 : Write the required annotation to inject the CustomerDAO object
	 */
	private CustomerDAO customerDAO;

	public List<CustomerBean> getCustomerByBillAmount(double amount) {
		List<CustomerBean> customerBeans = null;
		/*
		 * POA 12 : Complete the code to call a respective method from CustomerDAO
		 * to get the List of customer entities whose billAmount is greater than the given billAmount
		 * and restult is sorted is Descending order of customerName
		 * 
		 * Convert the List of customer entities to List of customer beans and return the same
		 */
		
		return customerBeans;
	}
	
	public Integer updateCustomerDetails(CustomerBean customerBean) {
		/*
		 * POA 13: Complete the code to call a respective method from CustomerDAO
		 * to update the customerDetails and return the same value
		 */
		return 0;
	}
	
	public static CustomerBean convertEntityToBean(CustomerEntity entity) {
		CustomerBean customer = new CustomerBean();
		BeanUtils.copyProperties(entity, customer);
		return customer;
	}

	public static CustomerEntity convertBeanToEntity(CustomerBean bean) {
		CustomerEntity customerEntityBean = new CustomerEntity();
		BeanUtils.copyProperties(bean, customerEntityBean);
		return customerEntityBean;
	}
}
