package com.accenture.ltt.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.bussiness.bean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAOWrapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	public Collection<EmployeeBean> getAllEmployee(){
		return employeeDAOWrapper.findAll();			
	}
	
	public Optional<EmployeeBean> getEmployeeDetailsById(int id){
		return employeeDAOWrapper.findOne(id);
	}
	
	public Integer addEmployee(EmployeeBean employee){
		return employeeDAOWrapper.saveEmployee(employee);
	}
	
	public Optional<EmployeeBean> updateEmployee (EmployeeBean employee){
		return employeeDAOWrapper.updateEmployee(employee);
	}
	
	public Optional<EmployeeBean> deleteEmployee (int id){
		return employeeDAOWrapper.deleteEmployee(id);
	}
	
}
