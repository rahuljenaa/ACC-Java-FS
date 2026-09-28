package com.accenture.ltt.collection.demo.userdefined;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTester {
	public static void main(String[] args) {
		Employee emp1 = new Employee(1001, "Employee1", 5, 60000);
		Employee emp2 = new Employee(1011, "Employee2", 8, 100000);
		Employee emp3 = new Employee(1006, "Employee3", 7, 80000);
		Employee emp4 = new Employee(1201, "Employee4", 3, 40000);
		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		EmployeeService service = new EmployeeService();
		service.printEmployeeDetails(empList);
	}
}