package com.accenture.ltt.junit.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.exceptions.InvalidEmailAddressException;
import com.accenture.ltt.service.EmployeeService;

class EmployeeServiceTest09 {

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
	@DisplayName("Assertions Test")
	public void testAssertions() {
		Employee emp = new Employee(1001, "John", 10000, 101, "john");
//		Employee emp1 = emp;
//		Assertions.assertSame(emp, emp1);
		
//		Employee emp2 = new Employee(1001, "John", 10000, 101, "john");
//		Assertions.assertNotSame(emp, emp2);
		
//		Assertions.assertEquals(10000, employeeService.computeSalary(emp, 10));
//		Assertions.assertEquals(10000, employeeService.computeSalary(emp, 10), "values are not equal");
		
//		Assertions.assertTrue(emp.getSalary() > 10000);
//		Assertions.assertTrue(emp.getSalary() > 10000, "Salary is not greater than 10000");
		
//		Assertions.assertAll("employee",
//				()->Assertions.assertEquals(9000, employeeService.computeSalary(emp, 10)),
//				()->Assertions.assertEquals(12000, employeeService.incrementSalary(emp, 2000)));
		
//		Throwable exception1 = Assertions.assertThrows(ArithmeticException.class, 
//				() -> employeeService.computeSalary(emp, 0));
//		Assertions.assertEquals("/ by zero", exception1.getMessage());
		
//		Throwable exception2 = Assertions.assertThrows(InvalidEmailAddressException.class, 
//				() -> employeeService.validateEmailAddress(emp));
//		Assertions.assertEquals("Employee's Email Address is invalid", exception2.getMessage());
		
		Assertions.assertTimeout(Duration.ofSeconds(2), () -> employeeService.getEmployeeDetails());
		
	}
}
