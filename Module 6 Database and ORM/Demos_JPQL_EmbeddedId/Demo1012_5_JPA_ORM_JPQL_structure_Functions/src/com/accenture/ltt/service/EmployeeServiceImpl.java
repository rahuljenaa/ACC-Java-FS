package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.utility.Factory;

public class EmployeeServiceImpl implements EmployeeService {

	

	@Override
	public List<Object> stringFunctionsDemo() throws Exception {
		List<Object> list = null;
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			list =employeeDAO.stringFunctionsDemo();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return list;
	}

	@Override
	public List<Object> dateFunctionsDemo() throws Exception {
		List<Object> list = null;
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			list =employeeDAO.dateFunctionsDemo();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return list;
	}
	
	@Override
	public List<Object> aggregateFunctionsDemo() throws Exception {
		List<Object> employees = null;
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			employees =employeeDAO.aggregateFunctionsDemo();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return employees;
	}


}
