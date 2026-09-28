package com.accenture.ltt.bean;

public class Employee {

	private Address address;
	private Integer employeeId;
	private Double salary;
	private String employeeName;
	
	
	
	public Employee(Address address) {
		this.address = address;
 
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
 
}