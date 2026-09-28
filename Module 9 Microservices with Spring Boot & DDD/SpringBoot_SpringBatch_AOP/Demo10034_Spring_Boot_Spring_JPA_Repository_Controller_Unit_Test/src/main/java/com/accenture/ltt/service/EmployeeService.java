package com.accenture.ltt.service;

import java.util.Collection;
import java.util.Optional;

import com.accenture.ltt.business.bean.EmployeeBean;

public interface EmployeeService {

	int addEmployee(EmployeeBean employee);

	Collection<EmployeeBean> getEmployeeDetails();

	Optional<EmployeeBean> getEmployeeDetailByEmployeeId(int employeeId);

	Optional<EmployeeBean> deleteEmployee(int employeeId);

	Optional<EmployeeBean> updateEmployee(EmployeeBean employeeBean);

}