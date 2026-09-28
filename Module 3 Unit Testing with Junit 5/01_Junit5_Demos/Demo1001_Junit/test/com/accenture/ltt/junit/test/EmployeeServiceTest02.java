package com.accenture.ltt.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.service.EmployeeService;

class EmployeeServiceTest02 {

	private static EmployeeService employeeService;

	@BeforeAll
	static void setup() {
		System.out.println("Setting up EmployeeService");
		employeeService = new EmployeeService();
	}

	@AfterAll
	static void tearDwon() {
		System.out.println("Tearing Down EmployeeService");
		employeeService = null;
	}

	@BeforeEach
	void beforeTestMethod(TestInfo testInfo) {
		System.out.println("Start Executing Test..." + testInfo.getDisplayName());
	}

	@AfterEach
	void afterTestMethod(TestInfo testInfo) {
		System.out.println("Completed Test..." + testInfo.getDisplayName());
	}

	@Test
	public void testIncrementSalary() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assertEquals(11000, employeeService.incrementSalary(emp, 1000));
	}

	@Test
	public void testComputeSalary() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assertEquals(9000, employeeService.computeSalary(emp, 10));
	}
}
