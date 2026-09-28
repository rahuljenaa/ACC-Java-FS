package com.accenture.ltt.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.accenture.ltt.entity.EmployeeEntity;
@SuppressWarnings("rawtypes")
@RepositoryDefinition(idClass=Integer.class,domainClass=EmployeeEntity.class)
@Transactional
public interface EmployeeDAO{
	
	@Query(name="EmployeeDAO.getAllEmployeesBySalary")
	List<EmployeeEntity> getAllEmployeesBySalary(Double salary);
	
	@Query(name="EmployeeDAO.getDeptCodesAndCountOfEmployee") 
	List getDeptCodesAndCountOfEmployee();
}
