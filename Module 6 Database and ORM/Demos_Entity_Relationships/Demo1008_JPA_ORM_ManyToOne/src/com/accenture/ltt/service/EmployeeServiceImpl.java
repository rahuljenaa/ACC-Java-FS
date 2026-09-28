package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.DepartmentBean;
import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.utility.Factory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Integer insertEmployeeAndDepartment(EmployeeBean employee1, EmployeeBean employee2, DepartmentBean d)
			throws Exception {
		int count = 0;
		try {
			EmployeeDAO employeeDAO = Factory.createEmployeeDAO();
			count = employeeDAO.insertEmployeeAndDepartment(employee1, employee2, d);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return count;
	}
}
