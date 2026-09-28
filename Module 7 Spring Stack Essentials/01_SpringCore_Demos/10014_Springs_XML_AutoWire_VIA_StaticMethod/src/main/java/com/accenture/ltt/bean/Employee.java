package com.accenture.ltt.bean;

public class Employee {

	private static  Address address;
	private Integer employeeId;
	private Double salary;
	private String employeeName;
	
	
	
	public Employee() {
		System.out.println("From Constructor of Employee: Created the Employee Object and injected the Address Object\n");
	}

	public static Address getAddress() {
		return address;
	}

	public static void setAddress(Address address) {
		System.out.println("static method invocation by spring framework");
		Employee.address = address;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void display() {
		System.out.println("\nEmployee Details are:");
		System.out.println("Employee ID:      " + this.employeeId);
		System.out.println("Employee Salaray: " + this.salary);
		System.out.println("\nAddress line1:  " + address.getAddressLine1());
		System.out.println("Address line2:    " + address.getAddressLine2());
	}
}