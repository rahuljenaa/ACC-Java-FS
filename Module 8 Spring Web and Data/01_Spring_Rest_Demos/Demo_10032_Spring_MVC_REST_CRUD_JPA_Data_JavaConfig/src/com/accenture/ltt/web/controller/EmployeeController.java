package com.accenture.ltt.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ltt.bussiness.bean.EmployeeBean;
import com.accenture.ltt.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping(value = "emp/controller/getDetails",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeBean>> getEmployeeDetails() {
		List<EmployeeBean> listEmployee = new ArrayList<EmployeeBean>(employeeServiceImpl.getAllEmployee());	
		return new ResponseEntity<List<EmployeeBean>>(listEmployee,HttpStatus.OK);
	}

	@GetMapping(value = "emp/controller/getDetailsById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) {
		Optional<EmployeeBean> employeeBean = employeeServiceImpl.getEmployeeDetailsById(myId);
		return employeeBean.map(redeemedOpt->new ResponseEntity<EmployeeBean>(redeemedOpt,HttpStatus.OK))
				.orElse(new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(value = "/emp/controller/addEmp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employee) {
		int count=employeeServiceImpl.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:" + count,HttpStatus.CREATED);
	}

	@PutMapping(value = "/emp/controller/updateEmp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody  EmployeeBean employee) {
		Optional<EmployeeBean> employeeBeanResult= employeeServiceImpl.updateEmployee(employee);
		return employeeBeanResult.map(redeemedOpt->new ResponseEntity<EmployeeBean>(redeemedOpt,HttpStatus.OK))
				.orElse(new ResponseEntity<EmployeeBean>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@DeleteMapping(value = "/emp/controller/deleteEmp/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> deleteEmployee(@PathVariable("id") int myId) {
		Optional<EmployeeBean> employeeBean= employeeServiceImpl.deleteEmployee(myId);
		return employeeBean.map(redeemedOpt->new ResponseEntity<EmployeeBean>(redeemedOpt,HttpStatus.OK))
				.orElse(new ResponseEntity<EmployeeBean>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
}