package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.utility.Factory;

public class EmployeeServiceImpl implements EmployeeService {

	public Integer addEmployee(EmployeeBean employee) throws Exception {
		int employeeId = 0;
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			employeeId = employeeDAO.addEmployee(employee);
		} catch (Exception exception) {
			throw exception;
		}
		return employeeId;
	}

	@Override
	public EmployeeBean getEmployeeDetails(int employeeId, int deptId) {
		EmployeeBean employee = null;
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			employee = employeeDAO.getEmployeeDetails(employeeId, deptId);
		} catch (Exception exception) {
			throw exception;
		}
		return employee;
	}
}
