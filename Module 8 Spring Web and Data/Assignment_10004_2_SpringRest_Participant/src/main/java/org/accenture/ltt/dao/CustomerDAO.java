package org.accenture.ltt.dao;

import java.util.List;
import java.util.Optional;

import org.accenture.ltt.entity.CustomerEntity;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(idClass = Integer.class, domainClass = CustomerEntity.class)
public interface CustomerDAO{
	public List<CustomerEntity> findByCustomerType(String customerType);
	public List<CustomerEntity> findByBillAmountBetween(double minBillAmount, double maxBillAmount);
	public CustomerEntity save(CustomerEntity customerEntity);
	public Optional<CustomerEntity> findById(Integer customerId);
}