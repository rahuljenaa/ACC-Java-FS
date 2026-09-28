package com.accenture.ltt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		return employeeDAO.addEmployee(employeeBean);
	}

	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		EmployeeBean emp = employeeDAO.getEmployeeDetails(id);
		if (emp == null) {
			throw new EmployeeNotFoundException();
		}
		return emp;
	}

	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		return employeeDAO.updateEmployeeDetails(employeeBean);
	}

	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception {
		return employeeDAO.deleteEmployeeDetails(id);
	}

	public List<EmployeeBean> getEmployeeList() throws Exception {
		return employeeDAO.getEmployeeList();
	}

}
