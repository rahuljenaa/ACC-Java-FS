package com.accenture.ltt.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.service.EmployeeService;
@TestInstance(Lifecycle.PER_CLASS)
class EmployeeServiceTest03 {

	private EmployeeService employeeService;

	@BeforeAll
	public void setup() {
		System.out.println("Setting up EmployeeService");
		employeeService = new EmployeeService();
	}

	@AfterAll
	public void tearDwon() {
		System.out.println("Tearing Down EmployeeService");
		employeeService = null;
	}

	@BeforeEach
	public void startTest(TestInfo testInfo) {
		System.out.println("Start Executing Test..." + testInfo.getDisplayName());
	}

	@AfterEach
	public void endTest(TestInfo testInfo) {
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
