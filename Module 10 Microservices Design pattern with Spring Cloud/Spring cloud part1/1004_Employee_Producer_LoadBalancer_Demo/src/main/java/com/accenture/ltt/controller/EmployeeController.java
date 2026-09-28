package com.accenture.ltt.controller;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private Environment environment;
	
	private static Map<Integer, Employee> mapOfEmloyeess = new LinkedHashMap<Integer, Employee>();
	static{
		mapOfEmloyeess.put(10001, new Employee("Jack",10001,12345.6,1001));
		mapOfEmloyeess.put(10002, new Employee("Justin",10002,12355.6,1002));
		mapOfEmloyeess.put(10003, new Employee("Eric",10003,12445.6,1003));
	}
	
	@RequestMapping(value = "emp/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployeeDetails() {
		Collection<Employee> listEmployee = mapOfEmloyeess.values();
		System.out.println("I am server with port number "+environment.getProperty("server.port")+". I am hit");
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
}
