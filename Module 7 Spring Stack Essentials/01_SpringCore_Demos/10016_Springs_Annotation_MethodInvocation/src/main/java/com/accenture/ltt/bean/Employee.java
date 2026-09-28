package com.accenture.ltt.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("empObject")
public class Employee {

	@Value("#{myAddress}")
	private Address address;
	
	@Value("1001")
	private Integer employeeId;
	
	@Value("#{myAddress.addressLine1}")
	private String addressLine1;
	
	
	private Double salary;
	
	
	@Value("#{myAddress.getAddressLine1().toUpperCase()}")
	private String employeeName;
	

	public Employee() {
		System.out.println("From Constructor of Employee: Created the Employee Object and injected the Address Object\n");
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
		System.out.println("FRom setter of EmployeeId");
		this.employeeId = employeeId;
	}

	public Double getSalary() {
		return salary;
	}
	
	

	@Value("#{myAddress.getDistance()*4500}")
	public void setSalary(Double salary) {
		System.out.println("From setter of Salary");
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
		System.out.println("Employee ID:" + this.employeeId);
		System.out.println("Address Line1 ID:" + this.addressLine1);
		System.out.println("Employee Salaray:" + this.salary);
		System.out.println("Emloyee Name: "+this.employeeName);
		System.out.println("\nAddress line1:" + this.address.getAddressLine1());
		System.out.println("Address line2:" + this.address.getAddressLine2());
	}
}