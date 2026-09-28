package com.accenture.ltt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.Employee;
import com.accenture.ltt.dao.EmployeeDAOWrapper;
@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	// Query Methods:
	public List<Employee> getAllEmployeesBySalary(Double salary){
		return employeeDAOWrapper.getAllEmployeesBySalary(salary);
	}

	@SuppressWarnings("rawtypes")
	public List getDeptCodesAndCountOfEmployee(){
		return employeeDAOWrapper.getDeptCodesAndCountOfEmployee();
	}
	
	
}
