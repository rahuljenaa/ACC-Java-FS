package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.utility.Factory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<EmployeeBean> retrieveEmployeeDetailsWithInSalaryRange1(Double lowerBound,Double upperBound) throws Exception {
		List<EmployeeBean> employees = null;
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			employees =employeeDAO.retrieveEmployeeDetailsWithInSalaryRange(lowerBound, upperBound);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return employees;
	}
}
