package com.accenture.ltt;

public class Employee {
	private int employeeId;
	private String employeeName;

	public Employee(String employeeName, int employeeId) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void displayDetails() {
		System.out.println("Employee Name: " + this.employeeName);
		System.out.println("Employee Id: " + this.employeeId);
	}
}
