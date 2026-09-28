package com.accenture.ltt.dao;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	
	Integer addEmployee(EmployeeBean employee) throws Exception;
	
	EmployeeBean findEmployeeById(Integer employeeId) throws Exception;
	
	EmployeeBean updateEmployee(EmployeeBean employeeBean) throws Exception;
	
	EmployeeBean deleteEmployeeById(Integer employeeId) throws Exception;
	
	
	
}
