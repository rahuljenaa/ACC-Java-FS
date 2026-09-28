package com.accenture.ltt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.OrderBean;
import com.accenture.ltt.dao.OrderDAOWrapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAOWrapper orderDAOWrapper;

	@Override
	public OrderBean save(OrderBean orderBean) {
		return orderDAOWrapper.save(orderBean);
	}
}
