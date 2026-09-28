package com.accenture.ltt.collection.demo.comparable;

public class Employee implements Comparable<Employee> {
	private int employeeId;
	private String employeeName;
	private int yearsOfExperience;
	private double salary;

	public int compareTo(Employee emp) {
		if (this.employeeId > emp.employeeId)
			return 1;
		else if (this.employeeId < emp.employeeId)
			return -1;
		else
			return 0;
	}

	public Employee(int employeeId, String employeeName, int yearsOfExperience, double salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.yearsOfExperience = yearsOfExperience;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public double getSalary() {
		return salary;
	}
}