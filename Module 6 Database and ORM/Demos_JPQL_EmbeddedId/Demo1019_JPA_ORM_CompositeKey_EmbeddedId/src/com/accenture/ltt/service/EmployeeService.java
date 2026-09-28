package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	Integer addEmployee(EmployeeBean employee) throws Exception;
	EmployeeBean getEmployeeDetails(int employeeId, int deptId);

}
