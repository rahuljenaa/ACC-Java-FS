package com.accenture.ltt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.bussiness.bean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAOImpl;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	public List<EmployeeBean> getAllEmployees() {

		return employeeDAOImpl.getAllEmployees();
	}
}
