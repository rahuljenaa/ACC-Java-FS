package com.accenture.ltt.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.ltt.model.Employee;

@FeignClient(name="employee",url="http://localhost:8095/emp/controller")
public interface MyFeignClient {

	@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
	ResponseEntity<List<Employee>> findAll(@RequestHeader("Authorization") String header);

	@RequestMapping(value = "/getDetailsById/{id}", method = RequestMethod.GET)
	ResponseEntity<Employee> findByEmployeeId(@RequestHeader("Authorization") String header,@PathVariable("id") Integer employeeId);
	
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	ResponseEntity<String> addEmployee(@RequestHeader("Authorization") String header,@RequestBody Employee employee);
	
	@RequestMapping(value="/updateEmp",method=RequestMethod.PUT)
	ResponseEntity<Employee> updateEmployee(@RequestHeader("Authorization") String header,@RequestBody Employee employee);
		
	@RequestMapping(value="/deleteEmp/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Employee> deleteEmployee(@RequestHeader("Authorization") String header,@PathVariable("id") int myId);
}