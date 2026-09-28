package com.accenture.ltt.junit.test;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.service.EmployeeService;

class EmployeeServiceTest10 {

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

	@Test
	@DisplayName("Increment Salary")
	public void testIncrementSalary() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assumeFalse(emp.getSalary() > 10000);
		assertEquals(11000, employeeService.incrementSalary(emp, 1000));
	}

	@Test
	@DisplayName("Tax Calculation")
	public void testComputeSalary() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assumeTrue(emp.getSalary() > 10000);
		assertEquals(90000, employeeService.computeSalary(emp, 10));
	}

	@Test
	@DisplayName("Assuming That")
	public void testAssumingThat() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		assumingThat(emp.getSalary() > 10000, () -> {
			System.out.println("Increment Salary");
			employeeService.incrementSalary(emp, 1000);
		});
		assumingThat(emp.getSalary() >= 10000, () -> {
			System.out.println("Tax computation");
			employeeService.computeSalary(emp, 10);
		});
	}
}
