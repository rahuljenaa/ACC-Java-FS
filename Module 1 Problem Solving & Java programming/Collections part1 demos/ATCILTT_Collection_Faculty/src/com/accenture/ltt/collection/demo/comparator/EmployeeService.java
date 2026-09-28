package com.accenture.ltt.collection.demo.comparator;
import java.util.List;

public class EmployeeService {
	public void printEmployeeDetails(List<Employee> employeeList) {
		employeeList.forEach(employee -> {
			System.out.println("Emp id is " + employee.getEmployeeId() + " Emp name is " + employee.getEmployeeName()
					+ " Emp experience is " + employee.getYearsOfExperience() + " Emp salary is "
					+ employee.getSalary());
		});
	}
}