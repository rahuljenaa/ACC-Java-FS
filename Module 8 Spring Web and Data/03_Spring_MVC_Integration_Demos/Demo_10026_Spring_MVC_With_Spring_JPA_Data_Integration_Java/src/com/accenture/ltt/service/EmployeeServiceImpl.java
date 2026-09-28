package com.accenture.ltt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAOWrapperImpl;
import com.accenture.ltt.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOWrapperImpl employeeDAOWrapperImpl;

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		return employeeDAOWrapperImpl.addEmployee(employeeBean);
	}

	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		Optional<EmployeeBean> employeeBean = employeeDAOWrapperImpl.getEmployeeDetails(id);
		return employeeBean.orElseThrow(EmployeeNotFoundException::new);
	}

	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		Optional<EmployeeBean> employeeBeanResult = employeeDAOWrapperImpl.updateEmployeeDetails(employeeBean);
		return employeeBeanResult.orElseThrow(EmployeeNotFoundException::new);
	}

	public EmployeeBean deleteEmployeeDetails(Integer empId) throws Exception {
		Optional<EmployeeBean> employeeBeanResult = employeeDAOWrapperImpl.deleteEmployeeDetails(empId);
		return employeeBeanResult.orElseThrow(EmployeeNotFoundException::new);
	}

	public List<EmployeeBean> getEmployeeList() throws Exception {
		return employeeDAOWrapperImpl.getEmployeeList();
	}
}
