package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	EmployeeBean findEmployeeById(int employeeId) throws Exception;

}
