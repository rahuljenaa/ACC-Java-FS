package com.accenture.ltt.controller;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.model.Employee;

@RestController
public class EmployeeController {
	
	private static Map<Integer, Employee> mapOfEmloyeess = new LinkedHashMap<Integer, Employee>();
	static int count=10003;
	static{
		mapOfEmloyeess.put(10001, new Employee("Jack",10001,12345.6,1001));
		mapOfEmloyeess.put(10002, new Employee("Justin",10002,12355.6,1002));
		mapOfEmloyeess.put(10003, new Employee("Eric",10003,12445.6,1003));
	}
	
	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployeeDetails(){
		Collection <Employee> listEmployee = mapOfEmloyeess.values();
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId){
		Employee employee = mapOfEmloyeess.get(myId);
		if(employee!=null){
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/emp/controller/addEmp",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		count++;
		mapOfEmloyeess.put(count,employee);
		employee.setEmployeeId(count);
		return new ResponseEntity<String>("Employee added successfully with id:"+count,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp/controller/updateEmp",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		if(mapOfEmloyeess.get(employee.getEmployeeId())==null){
			Employee employee2=null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		mapOfEmloyeess.put(employee.getEmployeeId(),employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int myId){
		if(mapOfEmloyeess.get(myId)==null){
			Employee employee2=null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employee employee = mapOfEmloyeess.remove(myId);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
}
