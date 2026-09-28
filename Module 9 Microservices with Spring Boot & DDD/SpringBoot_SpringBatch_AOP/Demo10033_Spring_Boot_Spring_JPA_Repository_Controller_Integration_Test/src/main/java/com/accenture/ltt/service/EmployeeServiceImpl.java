package com.accenture.ltt.service;

import java.util.Collection;
import java.util.Optional;

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

	public Optional<EmployeeBean> getEmployeeDetailByEmployeeId(int employeeId) { 
		return employeeDAOWrapper.getEmployeeDetailByEmployeeId(employeeId);
	}

	public Optional<EmployeeBean> deleteEmployee(int employeeId) {
		return employeeDAOWrapper.deleteEmployee(employeeId);
	}

	public Optional<EmployeeBean> updateEmployee(EmployeeBean employeeBean) {
		return employeeDAOWrapper.updateEmployee(employeeBean);
	}
}