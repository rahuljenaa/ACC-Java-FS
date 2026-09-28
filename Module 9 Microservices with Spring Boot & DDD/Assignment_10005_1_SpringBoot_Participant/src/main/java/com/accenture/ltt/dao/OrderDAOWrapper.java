package com.accenture.ltt.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ltt.business.bean.OrderBean;
import com.accenture.ltt.entity.OrderEntity;

@Repository
public class OrderDAOWrapper {

	@Autowired
	private OrderDAO orderDAO;

	public OrderBean save(OrderBean orderBean) {
		/*
		 * POA 4:Complete the code to convert the given orderBean to orderEntity
		 * and call a respective method from OrderDAO to save the orderEntity
		 * convert the orderEntity to orderBean and return the same
		 */
		return null;
	}
	private OrderBean convertEntityToBean(OrderEntity orderEntity) {
		OrderBean orderBean=new OrderBean();
		BeanUtils.copyProperties(orderEntity, orderBean);
		return orderBean;
	}
	private OrderEntity convertBeanToEntity(OrderBean orderBean) {
		OrderEntity orderEntity=new OrderEntity();
		BeanUtils.copyProperties(orderBean, orderEntity);
		return orderEntity;
	}
}