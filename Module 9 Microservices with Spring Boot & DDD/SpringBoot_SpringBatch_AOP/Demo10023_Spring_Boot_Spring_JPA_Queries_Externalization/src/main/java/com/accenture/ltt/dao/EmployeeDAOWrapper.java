package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.Employee;
import com.accenture.ltt.entity.EmployeeEntity;
@Service
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	// Query Methods:
	public List<Employee> getAllEmployeesBySalary(Double salary){
		List<EmployeeEntity> listEmployee= employeeDAO.getAllEmployeesBySalary(salary);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}

	@SuppressWarnings("rawtypes")
	public List getDeptCodesAndCountOfEmployee(){
		return employeeDAO.getDeptCodesAndCountOfEmployee();
	}
	
	
}
