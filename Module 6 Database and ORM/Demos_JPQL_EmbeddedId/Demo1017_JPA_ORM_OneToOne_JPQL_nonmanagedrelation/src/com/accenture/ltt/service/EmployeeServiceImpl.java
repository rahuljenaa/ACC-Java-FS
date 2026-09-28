package com.accenture.ltt.service;

import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.utility.Factory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void getAllEmployeesWithAssetDetails() throws Exception {
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			employeeDAO.getAllEmployeesWithAssetDetails();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

}
