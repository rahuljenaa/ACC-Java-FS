package com.accenture.ltt.dao;

import java.util.List;

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
		 * POA 8:Complete the code to convert the given orderBean to orderEntity
		 * and call a respective method from OrderDAO to save the orderEntity
		 * convert the orderEntity to orderBean and return the same
		 */
		return null;
	}

	public List<OrderBean> getOrdersInBillingRange(Double minBillAmount, Double maxBillAmount) {
		/*
		 * POA 9: Complete the code to call a respective method from OrderDAO to 
		 * reterive the List of orderBeans whose billAmount is in range of given minBillAmount and maxBillAmount
		 * Convert the List of orderBeans to List of orderEntity is list is not empty
		 * else return null
		 */
		return null;
	}

	public boolean updateOrderStatus(OrderBean orderBean) {
		/*
		 * POA 10: Complete the code to call a respective method from OrderDAO to find an orderEntity with a given orderId in orderBean
		 * If orderEntity reterived is not null modify the status with status in orderBean, save the orderEntity and return true
		 * else return false
		 */
		return false;
	}

	public OrderBean deleteOrder(Integer orderId) {
		/*
		 * POA 11: Complete the code to call a respective method from OrderDAO to find an orderEntity with a given orderId
		 * If orderEntity reterived is not null delete it and convert the orderEntity reterived to orderBean and return the same
		 * else reurn null
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