package com.accenture.ltt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import com.accenture.ltt.entity.Employee;
import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.dto.CreateEmployeeRequest;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
		Employee employee = new Employee();
		// sanitize basic whitespace
		employee.setEmployeeName(request.getEmployeeName().trim());
		employee.setEmployeeId(request.getEmployeeId());
		employee.setSalary(request.getSalary());
		employee.setDepartmentCode(request.getDepartmentCode());
		Employee saved = employeeService.createEmployee(employee);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeByEmployeeId(
			@PathVariable
			@Positive(message = "employee ID must be positive") Integer employeeId) {
		Employee employee = employeeService.getByEmployeeId(employeeId);
		System.out.println("hi there");
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(employee);
	}
}

