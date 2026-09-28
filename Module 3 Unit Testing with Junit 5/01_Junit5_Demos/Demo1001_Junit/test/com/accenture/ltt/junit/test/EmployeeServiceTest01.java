package com.accenture.ltt.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.service.EmployeeService;

class EmployeeServiceTest01 {

	private static EmployeeService employeeService;

	@BeforeAll
	public static void setup() {
		System.out.println("Setting up EmployeeService");
		employeeService = new EmployeeService();
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("Tearing Down EmployeeService");
		employeeService = null;
	}

	@Test
	public void testComputeSalary() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assertEquals(9000, employeeService.computeSalary(emp, 10));
	}
}
