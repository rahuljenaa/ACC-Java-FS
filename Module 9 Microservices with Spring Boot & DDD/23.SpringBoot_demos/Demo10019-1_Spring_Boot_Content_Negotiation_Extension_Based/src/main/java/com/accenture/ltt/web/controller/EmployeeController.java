package com.accenture.ltt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.business.bean.Employee;
import com.accenture.ltt.dao.EmployeeDAO;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/employee/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return employeeDAO.getEmployeeDetailsById(id);
	}
}
