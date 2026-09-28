package com.accenture.ltt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.entity.Employee;
import com.accenture.ltt.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getByEmployeeId(Integer employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}
}

