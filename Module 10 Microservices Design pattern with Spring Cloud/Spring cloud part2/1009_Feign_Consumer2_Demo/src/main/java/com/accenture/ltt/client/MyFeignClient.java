package com.accenture.ltt.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.ltt.model.Employee;

@FeignClient(name="employee",url="http://localhost:7091/",decode404=true)
public interface MyFeignClient {

	@RequestMapping(value = "/emp/controller/getDetails", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> findAll();

	@RequestMapping(value = "/emp/controller/getDetailsById/{id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> findByEmployeeId(@PathVariable("id") Integer employeeId);
	
	@RequestMapping(value="/emp/controller/addEmp",
			method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee);
	
	@RequestMapping(value="/emp/controller/updateEmp",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee);
		
	@RequestMapping(value="/emp/controller/deleteEmp/{id}",
			method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int myId);
}