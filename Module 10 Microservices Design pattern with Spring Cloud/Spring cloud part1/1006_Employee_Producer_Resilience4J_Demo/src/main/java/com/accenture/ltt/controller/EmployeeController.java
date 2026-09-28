package com.accenture.ltt.controller;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.model.Employee;

@RestController
public class EmployeeController {

	private static Map<Integer, Employee> mapOfEmloyeess = new LinkedHashMap<Integer, Employee>();
	private static int count = 0;
	private static boolean flag=true;
	static {
		mapOfEmloyeess.put(10001, new Employee("Jack", 10001, 12345.6, 1001));
		mapOfEmloyeess.put(10002, new Employee("Justin", 10002, 12355.6, 1002));
		mapOfEmloyeess.put(10003, new Employee("Eric", 10003, 12445.6, 1003));
	}
	
	@RequestMapping(value = "emp/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployeeDetails3() throws Exception {
		Collection<Employee> listEmployee = mapOfEmloyeess.values();
		if(flag) {
			count++;
			if (count%2==0) {
	            return new ResponseEntity<Collection<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
		}
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	//http://localhost:7091/emp/controller/setFlag/true
	@RequestMapping(value = "emp/controller/setFlag/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> setFlag(@PathVariable("value")Boolean value) throws Exception {
		flag=value;
		return new ResponseEntity<String>("Flag set to "+value+"...", HttpStatus.OK);
	}
}
