package com.accenture.ltt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.entity.CustomerEntity;

/*
 * POA 6 : Annotate with required annotation to make this class a spring managed bean 
 * POA 7 : Annotate with required annotation to enable Spring managed transaction 
 */
public class CustomerDAOImpl implements CustomerDAO {

	/*
	 * POA 8 : Write the required annotation to inject 
	 */
	private EntityManager entityManager;

	public Integer addCustomer(CustomerBean customerBean) {
		Integer customerId = 0;
		/*
		 * POA 9 : complete the code to insert the record into the table and 
		 * assign the customerId generated to the customerId variable to return 
		 */
		return customerId;
	}

	public CustomerBean updateCustomerDetails(CustomerBean customerBean) {
		CustomerBean customerBean2 = null;
		/*
		 * POA 10 : complete the code to retrieve the customer data for the customerId in customerBean
		 * if customer data found, assign the new values to the entity and save in to the table
		 * and return the updated data
		 */
		return customerBean2;
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
