package com.accenture.ltt.service;

import com.accenture.ltt.business.bean.EmployeeBean;

public interface EmployeeService {


	Integer addEmployee(EmployeeBean employeeBean) throws Exception;

	EmployeeBean getEmployeeDetails(Integer id) throws Exception;

	EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception;

	EmployeeBean deleteEmployeeDetails(Integer id) throws Exception;

	


}
