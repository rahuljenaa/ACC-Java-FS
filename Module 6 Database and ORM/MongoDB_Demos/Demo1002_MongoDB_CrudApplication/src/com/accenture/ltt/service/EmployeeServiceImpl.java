package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAO employeeDAO =new EmployeeDAOImpl();
	
	@Override
	public int insertEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return employeeDAO.insertEmployee(bean);
	}

	@Override
	public List<EmployeeBean> readEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.readEmployee();
	}

	@Override
	public void updateEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		employeeDAO.updateEmployee(bean);
	}

	@Override
	public void deleteEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(bean);
	}

}
