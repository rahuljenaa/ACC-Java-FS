package com.accenture.ltt.service;

import java.util.Collection;
import java.util.Optional;

import com.accenture.ltt.bussiness.bean.EmployeeBean;

public interface EmployeeService {

	Collection<EmployeeBean> getAllEmployee();

	Optional<EmployeeBean> getEmployeeDetailsById(int id);

	Integer addEmployee(EmployeeBean employee);

	Optional<EmployeeBean> updateEmployee(EmployeeBean employee);

	Optional<EmployeeBean> deleteEmployee(int id);

}