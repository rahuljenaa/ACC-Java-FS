package com.accenture.llt.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.llt.model.Employee;
import com.accenture.llt.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	private void logInsecureAccess(String endpoint) {
		System.out.println("[INSECURE DEMO] Unauthenticated access allowed to endpoint: " + endpoint + ". This is unsafe in production.");
	}
	
	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployeeDetails(){
		logInsecureAccess("GET /emp/controller/getDetails");
		Collection <Employee> listEmployee = employeeService.getEmployeeDetails();
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId){
		logInsecureAccess("GET /emp/controller/getDetailsById/{id}");
		Employee employee = employeeService.getEmployeeDetailByEmployeeId(myId);
		
		if(employee!=null){
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/emp/controller/addEmp",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		logInsecureAccess("POST /emp/controller/addEmp");
		int id= employeeService.addEmployee(employee);
		System.out.println("[id]:"+id);
		return new ResponseEntity<String>("Employee added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp/controller/updateEmp",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		logInsecureAccess("PUT /emp/controller/updateEmp");
		Employee employee2= employeeService.updateEmployee(employee);
		if(employee2==null){
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(employee);
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",
			method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int myId){
		logInsecureAccess("DELETE /emp/controller/deleteEmp/{id}");
		Employee employee= employeeService.deleteEmployee(myId);
		if(employee==null){
			return new ResponseEntity<Employee>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Removed: "+employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
}
