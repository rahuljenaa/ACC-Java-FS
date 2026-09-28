package com.accenture.ltt.junit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.service.EmployeeService;

class EmployeeServiceTest07 {

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

	@ParameterizedTest
	@ValueSource(ints = {1000, 2000, 3000, 4000})
	@DisplayName("Increment Salary")
	public void testIncrementSalary1(int value) {
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		int expected = emp.getSalary() + value;
		assertEquals(expected, employeeService.incrementSalary(emp, value));
	}

	@ParameterizedTest
	@ValueSource(strings = {"John","Jack","Joe","Jim"})
	@DisplayName("Employee Name")
	public void testEmployeeName(String value) {
		assertTrue(value.length() >= 3);
	}
		
	enum DepartmentName{
		LKM(101),
		HR(102),
		FINANCE(103);

		private int departmentCode;
		private DepartmentName(int departmentCode) {
			this.departmentCode = departmentCode;
		}
		public int getDepartmentCode() {
			return departmentCode;
		}
		public void setDepartmentCode(int departmentCode) {
			this.departmentCode = departmentCode;
		}
	}
	
	@ParameterizedTest
	@EnumSource(DepartmentName.class)
	@DisplayName("Enum Test")
	public void departmentNameTest(DepartmentName departmentName) {
		assertNotNull(departmentName);
		assertTrue(departmentName.getDepartmentCode() > 100);
		System.out.println(departmentName);
		System.out.println(departmentName.getDepartmentCode());
	}
	
	static List<Employee> getEmployeeListData(){
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1001, "John", 10000, 101, "john@accenture.com"));
		empList.add(new Employee(1002, "Jack", 20000, 102, "jack@accenture.com"));
		empList.add(new Employee(1003, "Tim", 13000, 101, "tim@accenture.com"));
		return empList;
	}
	
	@ParameterizedTest
	@MethodSource("getEmployeeListData")
	@DisplayName("Employees")
	public void testEmployee(Employee value) {
		assertNotNull(value);
	}
	
	@ParameterizedTest
	@CsvSource(value = { "1001,John,10000,101,john@accenture.com", "1002,Jack,20000,102,jack@accenture.com"})
	@DisplayName("CSV Test")
	public void defaultDelimiterCsvTest(int empId, String empName, int salary, int departmentCode, String email) {
		assertTrue(empId > 1000);
		assertNotNull(empName);
		assertTrue(salary >= 10000);
		assertTrue(departmentCode > 100);
		assertNotNull(email);
	}
	
	@ParameterizedTest
	@CsvSource(value = { "1001-John-10000-101-john@accenture.com", "1002-Jack-20000-102-jack@accenture.com"}, 
					delimiter='-')
	@DisplayName("CSV Test")
	public void customDelimiterCsvTest(int empId, String empName, int salary, int departmentCode, String email) {
		assertTrue(empId > 1000);
		assertNotNull(empName);
		assertTrue(salary >= 10000);
		assertTrue(departmentCode > 100);
		assertNotNull(email);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/resources/employees.csv")
	@DisplayName("CSV file test")
	public void csvFileTest(int empId, String empName, int salary, int departmentCode, String email) {
		assertTrue(empId > 1000);
		assertNotNull(empName);
		assertTrue(salary >= 10000);
		assertTrue(departmentCode > 100);
		assertNotNull(email);
	}
}
