package com.accenture.ltt.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.service.EmployeeService;

class EmployeeServiceTest05 {

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
	void startTest(TestInfo testInfo) {
		System.out.println("Start Executing Test..." + testInfo.getDisplayName());
	}

	@AfterEach
	void endTest(TestInfo testInfo) {
		System.out.println("Completed Test..." + testInfo.getDisplayName());
	}

	@RepeatedTest(value = 3)
	@DisplayName("Increment Salary")
	public void testIncrementSalary() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assertEquals(11000, employeeService.incrementSalary(emp, 1000));
	}

	@RepeatedTest(value = 3, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
	@DisplayName("Tax Calculation")
	public void testComputeSalary() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assertEquals(9000, employeeService.computeSalary(emp, 10));
	}
}
