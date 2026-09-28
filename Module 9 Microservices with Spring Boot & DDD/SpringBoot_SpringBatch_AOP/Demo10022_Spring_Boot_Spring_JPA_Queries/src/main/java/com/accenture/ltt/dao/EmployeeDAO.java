package com.accenture.ltt.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.accenture.ltt.entity.EmployeeEntity;

@SuppressWarnings("rawtypes")
@RepositoryDefinition(idClass=Integer.class,domainClass=EmployeeEntity.class)
@Transactional
public interface EmployeeDAO{
	
	//Query Method Approach
	List<EmployeeEntity> findBySalaryGreaterThanEqual(Double salary);
	List<EmployeeEntity> findByDepartmentCodeAndSalaryGreaterThanEqual(Integer department,double salary);
	List<EmployeeEntity> findAllByOrderByDepartmentCodeDesc ();
	
	//like
	List<EmployeeEntity> findByEmployeeNameContainingOrderByDepartmentCodeDesc(String pattern);
	List<EmployeeEntity> findByDepartmentCodeGreaterThanEqualAndDepartmentCodeLessThanEqual(Integer param1, Integer param2);
	List<EmployeeEntity> findByDepartmentCodeBetween(Integer param1, Integer param2);

	
	@Query(name="q1")
	List<String> getAllEmployeesBySalary(Double salary);

	@Query("select count(k),k.departmentCode from EmployeeEntity k group by k.departmentCode") 
	List getDeptCodesAndCountOfEmployee();
	// if @query is not having a valid query then 
	// then method signature is checked for the query method approach and translation 

	@Query("select k from EmployeeEntity k where k.salary>=:sal3 and k.salary=:sal4")
	List<EmployeeEntity> getAllEmployeesBySalary(@Param("sal4")Double sal4, @Param("sal3")Double sal67);
	
	
	@Query("UPDATE EmployeeEntity E set E.employeeName=?1 where E.employeeId=?2")
	@Modifying
	Integer updateEmployeeName(String employeeName,Integer empId);
}
