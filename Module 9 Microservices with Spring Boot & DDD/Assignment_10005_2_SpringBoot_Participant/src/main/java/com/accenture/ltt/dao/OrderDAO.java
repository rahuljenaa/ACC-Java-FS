package com.accenture.ltt.dao;

import java.util.List;

import com.accenture.ltt.entity.OrderEntity;

/*
 * POA 6 : Extend the interface with required Repository to perform the CRUD Operations
 */
public interface OrderDAO{
	
	/*
	 * POA 7 : Name a method using the QueryMethodApproach such that it reterives the order details whose billAmount is 
	 * between is given minBillAmount and maxBillAmount
	 */
	
	
	List<OrderEntity> __________________________(Double minBillAmount, Double maxBillAmount);
}