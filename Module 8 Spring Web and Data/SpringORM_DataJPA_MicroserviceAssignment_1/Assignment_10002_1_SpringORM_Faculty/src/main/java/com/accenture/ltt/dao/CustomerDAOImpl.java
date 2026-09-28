package com.accenture.ltt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ltt.business.bean.CustomerBean;
import com.accenture.ltt.entity.CustomerEntity;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Integer addCustomer(CustomerBean customerBean) {
		Integer customerId = 0;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		CustomerEntity customerEntityBean = convertBeanToEntity(customerBean);
		entityManager.getTransaction().begin();
		entityManager.persist(customerEntityBean);
		entityManager.getTransaction().commit();
		customerId = customerEntityBean.getCustomerId();
		return customerId;
	}
	public static CustomerEntity convertBeanToEntity(CustomerBean bean) {
		CustomerEntity customerEntityBean = new CustomerEntity();
		BeanUtils.copyProperties(bean, customerEntityBean);
		return customerEntityBean;
	}

}
