package com.accenture.ltt.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAOWrapper;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;

	public int addEmployee(EmployeeBean employee) {
		return employeeDAOWrapper.addEmployee(employee);
	}

	public Collection<EmployeeBean> getEmployeeDetails() {
		return employeeDAOWrapper.getEmployeeDetails();
	}

	public EmployeeBean getEmployeeDetailByEmployeeId(int employeeId) { 
		return employeeDAOWrapper.getEmployeeDetailByEmployeeId(employeeId);
	}

	public EmployeeBean deleteEmployee(int employeeId) {
		return employeeDAOWrapper.deleteEmployee(employeeId);
	}

	public EmployeeBean updateEmployee(EmployeeBean employeeBean) {
		return employeeDAOWrapper.updateEmployee(employeeBean);
	}
}