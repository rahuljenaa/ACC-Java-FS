package com.accenture.ltt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.dao.EmployeeDAOWrapper;

@Service
@SuppressWarnings("rawtypes")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private  EmployeeDAOWrapper employeeDAOWrapper;

	public List stringFunctions() throws Exception{
		return employeeDAOWrapper.stringFunctions();
	}

	public List groupByExampleNamed()throws Exception {
		return employeeDAOWrapper.groupByExampleNamed();
	}
	
}
