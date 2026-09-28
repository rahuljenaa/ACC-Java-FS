package com.accenture.ltt.dao;

import com.accenture.ltt.business.bean.EmployeeBean;

public interface EmployeeDAO {

	Integer addEmployee(EmployeeBean employeeBean) throws Exception;

	EmployeeBean getEmployeeDetails(Integer id) throws Exception;

	EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception;

	EmployeeBean deleteEmployeeDetails(Integer id) throws Exception;

}