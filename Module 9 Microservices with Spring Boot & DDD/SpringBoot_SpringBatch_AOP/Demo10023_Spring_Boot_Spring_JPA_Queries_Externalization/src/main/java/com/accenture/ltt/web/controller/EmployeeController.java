package com.accenture.ltt.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.business.bean.Employee;
import com.accenture.ltt.service.EmployeeServiceImpl;

@RestController
// extends @Controller
// object are automatically converted to JSON or XML
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	
	//http://localhost:8090/emp/controller/getDetailsSalary/20000
	@RequestMapping(value="emp/controller/getDetailsSalary/{sal}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getAllEmployeesBySalary(@PathVariable("sal")Double salary ){
		Collection <Employee> listEmployee = employeeService.getAllEmployeesBySalary(salary);
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	//http://localhost:8090/emp/controller/getEmployeeCountDept
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="emp/controller/getEmployeeCountDept",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection> getDeptCodesAndCountOfEmployee(){
		Collection listEmployee = employeeService.getDeptCodesAndCountOfEmployee();
		System.out.println(listEmployee);
		return new ResponseEntity<Collection>(listEmployee, HttpStatus.OK);
	}

}
