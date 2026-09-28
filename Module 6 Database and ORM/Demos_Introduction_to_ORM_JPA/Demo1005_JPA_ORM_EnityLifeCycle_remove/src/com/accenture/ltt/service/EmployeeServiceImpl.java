package com.accenture.ltt.service;

import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.utility.Factory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void removeEmployeeById(int employeeId) throws Exception {
		// TODO Auto-generated method stub
		try {
		EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
		employeeDAO.removeEmployeeById(employeeId);
		}catch (Exception exception) {
			throw exception;
		}
	}

}
