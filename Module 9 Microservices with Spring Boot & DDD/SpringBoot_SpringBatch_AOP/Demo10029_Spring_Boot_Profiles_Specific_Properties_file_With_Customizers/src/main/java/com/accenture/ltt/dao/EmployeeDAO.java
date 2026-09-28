package com.accenture.ltt.dao;

import java.util.Collection;

import com.accenture.ltt.bussiness.bean.Employee;

public interface EmployeeDAO {

	Collection<Employee> getAllEmployee();

	Employee getEmployeeDetailsById(int id);

	Integer addEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee removeEmployee(int id);

}