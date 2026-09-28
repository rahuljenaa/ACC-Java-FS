package com.accenture.ltt.web.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired(required = false)
	private EmployeeService employeeService;

	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EmployeeBean>> getEmployeeDetails(){
		Collection <EmployeeBean> listEmployee = employeeService.getEmployeeDetails();
		return new ResponseEntity<Collection<EmployeeBean>>(listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId){
		Optional<EmployeeBean> employeeBean = employeeService.getEmployeeDetailByEmployeeId(myId);
		return employeeBean.map(redeemedOpt->new ResponseEntity<EmployeeBean>(redeemedOpt,HttpStatus.OK)).orElse(new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(value="/emp/controller/addEmp",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employee){
		System.out.println("In Controller -> "+employee.hashCode());
		int id= employeeService.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/emp/controller/updateEmp",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employeeBean){
		Optional<EmployeeBean> employeeBeanResult= employeeService.updateEmployee(employeeBean);
		return employeeBeanResult.map(redeemedOpt->new ResponseEntity<EmployeeBean>(redeemedOpt,HttpStatus.OK)).orElse(new ResponseEntity<EmployeeBean>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> deleteEmployee(@PathVariable("id") int myId){
		Optional<EmployeeBean> employeeBean= employeeService.deleteEmployee(myId);
		return employeeBean.map(redeemedOpt->new ResponseEntity<EmployeeBean>(redeemedOpt,HttpStatus.OK)).orElse(new ResponseEntity<EmployeeBean>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
}
