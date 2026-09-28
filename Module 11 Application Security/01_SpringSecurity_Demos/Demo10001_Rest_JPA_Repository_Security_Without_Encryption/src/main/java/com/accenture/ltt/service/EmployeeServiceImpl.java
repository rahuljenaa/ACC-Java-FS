package com.accenture.ltt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.entity.EmployeeEntity;
import com.accenture.ltt.model.Employee;
@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAO employeeDAO;

	public int addEmployee(Employee employee) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		EmployeeEntity emp= (EmployeeEntity)employeeDAO.save(employeeEntity);
		System.out.println(emp);
		return emp.getEmployeeId();
	}

	public Collection<Employee> getEmployeeDetails(){
		Collection<EmployeeEntity> collec =employeeDAO.findAll();
		List<Employee> listEmployee = new ArrayList<Employee> ();
		for (EmployeeEntity employeeEntity : collec) {
			Employee employee=new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			listEmployee.add(employee);
		}
		return listEmployee;
		
	}
	
	public Employee getEmployeeDetailByEmployeeId(int employeeId){
		Employee employee =null;
		Optional<EmployeeEntity> employeeEntity= employeeDAO.findById(employeeId);
		if(employeeEntity.isPresent()){
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity.get(), employee);
		}
		return employee;
	}
	public Employee deleteEmployee(int employeeId){
		Employee employee =null;
		Optional<EmployeeEntity> employeeEntity= employeeDAO.findById(employeeId);
		if(employeeEntity.isPresent()){
			EmployeeEntity employeeEntity2=employeeEntity.get();
			employee=new Employee();
			BeanUtils.copyProperties(employeeEntity2, employee);
			employeeDAO.delete(employeeEntity2);
		}
		return employee;
	}
	
	public Employee updateEmployee(Employee employee){
		Optional<EmployeeEntity> employeeEntity= employeeDAO.findById(employee.getEmployeeId());
		if(employeeEntity.isPresent()){
			EmployeeEntity employeeEntity2=employeeEntity.get();
			BeanUtils.copyProperties(employee,employeeEntity2);	
			employeeDAO.save(employeeEntity2);
			return employee;
		}
		return null;
	}
}