package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	Integer addEmployee(EmployeeBean employee) throws Exception;

	EmployeeBean findEmployeeById(Integer employeeId) throws Exception;

	EmployeeBean updateEmployee(EmployeeBean employeeBean) throws Exception;

	EmployeeBean deleteEmployeeById(Integer employeeId) throws Exception;
}
