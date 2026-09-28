package com.accenture.ltt.dao;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	
	EmployeeBean findEmployeeById(int employeeId) throws Exception;
	
}
