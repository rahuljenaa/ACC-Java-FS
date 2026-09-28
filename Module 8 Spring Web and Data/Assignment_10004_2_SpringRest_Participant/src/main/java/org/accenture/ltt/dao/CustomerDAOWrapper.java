package org.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.accenture.ltt.business.bean.CustomerBean;
import org.accenture.ltt.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOWrapper {

	@Autowired
	private CustomerDAO customerDAO;

	 
	public List<CustomerBean> findByCustomerType(String customerType) {
		List<CustomerBean> customerBeans = null;
		List<CustomerEntity> entities = customerDAO.findByCustomerType(customerType);
		if (entities.size() > 0) {
			customerBeans = new ArrayList<CustomerBean>();
			for (CustomerEntity entity : entities) {
				CustomerBean bean = convertEntityToBean(entity);
				customerBeans.add(bean);
			}
		}
		return customerBeans;
	}

	 
	public List<CustomerBean> findByBillAmountBetween(double minBillAmount, double maxBillAmount) {
		List<CustomerBean> customerBeans = null;
		List<CustomerEntity> entities = customerDAO.findByBillAmountBetween(minBillAmount, maxBillAmount);
		if (entities.size() > 0) {
			customerBeans = new ArrayList<CustomerBean>();
			for (CustomerEntity entity : entities) {
				CustomerBean bean = convertEntityToBean(entity);
				customerBeans.add(bean);
			}
		}
		return customerBeans;
	}

	 
	public CustomerBean save(CustomerBean customerBean) {
		CustomerEntity customerEntity = convertBeanToEntity(customerBean);
		customerEntity=customerDAO.save(customerEntity);
		customerBean = convertEntityToBean(customerEntity);
		return customerBean;
	}

	 
	public CustomerBean findById(Integer customerId) {
		Optional<CustomerEntity> customerEntity = customerDAO.findById(customerId);
		if (customerEntity.isPresent()) {
			CustomerBean customerBean = convertEntityToBean(customerEntity.get());
			return customerBean;
		}
		return null;
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
