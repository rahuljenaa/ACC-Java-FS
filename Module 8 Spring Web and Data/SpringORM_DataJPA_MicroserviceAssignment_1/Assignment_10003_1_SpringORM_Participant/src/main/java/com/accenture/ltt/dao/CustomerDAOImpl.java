package com.accenture.ltt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.entity.CustomerEntity;

/*
 * POA 4 : Annotate with required annotation to make this class a spring managed bean  
 */
public class CustomerDAOImpl implements CustomerDAO {

	/*
	 * POA 5 : Write the required annotation to inject EntityManagerFactory
	 */
	private EntityManagerFactory entityManagerFactory;

	public Integer addCustomer(CustomerBean customerBean) {
		Integer customerId = 0;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		/*
		 * POA 6 : complete the code to insert the record into the table and 
		 * assign the customerId generated to the customerId variable to return 
		 * Make sure to start and commit the transaction
		 */
		return customerId;
	}


	public static CustomerEntity convertBeanToEntity(CustomerBean bean) {
		CustomerEntity customerEntityBean = new CustomerEntity();
		BeanUtils.copyProperties(bean, customerEntityBean);
		return customerEntityBean;
	}

}
