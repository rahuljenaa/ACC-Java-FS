package com.accenture.ltt.ui;

import java.util.Scanner;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.service.EmployeeService;

public class UITester {
	public static void main(String[] args) {
		Employee employee = createEmployee();
		EmployeeService employeeService = createEmployeeService();

		try (Scanner scanner = new Scanner(System.in)) {
			int newSal = employeeService.incrementSalary(employee, 3000);
			employee.setSalary(newSal);
			System.out.println("Enter tax Rate ");
			int finalSalary = employeeService.computeSalary(employee, scanner.nextInt());
			System.out.println("Salary after tax reduction is " + finalSalary);
		}catch(ArithmeticException | NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static Employee createEmployee() {
//		Employee emp = null;
		Employee emp = new Employee(1001, "John", 10000, 101, "john@accenture.com");
		return emp;
	}

	public static EmployeeService createEmployeeService() {
		return new EmployeeService();
	}
}
