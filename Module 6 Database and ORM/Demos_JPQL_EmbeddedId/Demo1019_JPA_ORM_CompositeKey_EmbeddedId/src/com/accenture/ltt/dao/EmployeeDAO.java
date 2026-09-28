package com.accenture.ltt.dao;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	
	Integer addEmployee(EmployeeBean employee) throws Exception;
	EmployeeBean getEmployeeDetails(int employeeId, int deptId);
	
}
