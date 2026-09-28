package com.accenture.ltt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ltt.entity.CustomerEntity;

/*
 * POA 6 : Annotate the interface with required annotation to customize the repository and expose only selected methods
 */
@Transactional(value="txManager")
public interface CustomerDAO {
	
	/*
	 * POA 7 : Name a method using the QueryMethodApproach such that it reterives the customer details whose billAmount is GreaterThan given amount in argument and 
	 * Order the result is Descending order of CustomerName
	 */
	public List<CustomerEntity> ___________________________________(double amount);

	/*
	 * POA 8 : Annotate the method with required annotation to execute the DML query
	 */
	@Query("update CustomerEntity c set c.billAmount = :amount, c.customerType = :ctype where c.customerName = :name")
	/*
	 * POA 9 : Annotate the method parameters with required annotations to to bind method parameters to a query named parameters 
	 */
	public Integer updateCustomerDetails(String customerName,double billAmount, String customerType);
}