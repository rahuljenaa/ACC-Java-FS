package com.accenture.ltt.web.controller;

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

import com.accenture.ltt.business.bean.Employee;
import com.accenture.ltt.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	//query method
	//http://localhost:8090/emp/controller/getDetails/dept=101,sal=11000 
	@RequestMapping(value="emp/controller/getDetails/dept={v1},sal={v2}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getAllEmployeeFromDepartmentGTSalary(@PathVariable("v1")Integer departmentCode,@PathVariable("v2")double salary){
		Collection <Employee> listEmployee = employeeService.getAllEmployeeFromDepartmentGTSalary(departmentCode,salary);
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	//http://localhost:8090/emp/controller/getDetailsOrderByDeptDesc
	@RequestMapping(value="emp/controller/getDetailsOrderByDeptDesc",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployeeDetailsOrderByDepartmentCodeDesc(){
		Collection <Employee> listEmployee = employeeService.getEmployeeDetailsOrderByDepartmentcodedesc();
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	//http://localhost:8090/emp/controller/getDetailsEmpNamePatternOrderByDeptDesc/J
	@RequestMapping(value="emp/controller/getDetailsEmpNamePatternOrderByDeptDesc/{patt}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> findByEmployeeNameContainingOrderByDepartmentCodeDesc(@PathVariable("patt") String pattern){
		Collection <Employee> listEmployee = employeeService.findByEmployeeNameContainingOrderByDepartmentCodeDesc(pattern);
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	//http://localhost:8090/emp/controller/getDetailsBetweenDept/param1=101--param2=102	
	@RequestMapping(value="emp/controller/getDetailsBetweenDept/param1={v1}--param2={v2}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> findByDepartmentCodeGreaterThanEqualAndLessThanEqual(@PathVariable("v1") Integer var1,@PathVariable("v2") Integer var2){
		Collection <Employee> listEmployee = employeeService.findByDepartmentCodeGreaterThanEqualAndLessThanEqual(var1,var2);
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	//http://localhost:8090/emp/controller/getDetailsBetweenDept2/param1=101--param2=102
	@RequestMapping(value="emp/controller/getDetailsBetweenDept2/param1={v1}--param2={v2}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> findByDepartmentBetween(@PathVariable("v1") Integer var1,@PathVariable("v2") Integer var2){
		Collection <Employee> listEmployee = employeeService.findByDepartmentBetween(var1,var2);
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	//http://localhost:8090/emp/controller/getDetailsSalary/20000
	@RequestMapping(value="emp/controller/getDetailsSalary/{sal}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<String>> getAllEmployeesBySalary(@PathVariable("sal")Double salary ){
		Collection <String> listEmployee = employeeService.getAllEmployeesBySalary(salary);
		System.out.println(listEmployee);
		return new ResponseEntity<Collection<String>>(listEmployee, HttpStatus.OK);
	}
	
	
	//http://localhost:8090/emp/controller/getEmployeeCountDept
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="emp/controller/getEmployeeCountDept",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection> getDeptCodesAndCountOfEmployee(){
		Collection listEmployee = employeeService.getDeptCodesAndCountOfEmployee();
		System.out.println(listEmployee);
		return new ResponseEntity<Collection>(listEmployee, HttpStatus.OK);
	}
	
	//PUT(Complete Payload ) VS PATCH(Partial Payload) 
	//http://localhost:8090/emp/controller/updateEmp
	@RequestMapping(value="emp/controller/updateEmp",method=RequestMethod.PATCH,produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> updateName(@RequestBody Employee employee){
		Integer i = employeeService.updateEmpName(employee.getEmployeeName(),employee.getEmployeeId());
		if(i>=1) {
			return new ResponseEntity<String>("Updated", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Record not found with given eid", HttpStatus.NOT_FOUND);
		}
	}
	
}
