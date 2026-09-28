package com.accenture.ltt.service;

import java.util.Collection;

import com.accenture.ltt.bussiness.bean.EmployeeBean;

public interface EmployeeService {

	Collection<EmployeeBean> getAllEmployee();

	EmployeeBean getEmployeeDetailsById(int id);

	Integer addEmployee(EmployeeBean employee);

	EmployeeBean updateEmployee(EmployeeBean employee);

	EmployeeBean removeEmployee(int id);

}