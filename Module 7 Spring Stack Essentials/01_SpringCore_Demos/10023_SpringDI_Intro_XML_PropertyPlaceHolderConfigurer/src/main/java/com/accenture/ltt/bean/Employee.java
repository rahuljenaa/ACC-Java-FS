package com.accenture.ltt.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Employee {
	@Autowired
	private Address address;
	@Value("${EmployeeId}")
	private Integer employeeId;
	@Value("${Salary}")
	private Double salary;
	@Value("${EmployeeName}")
	private String employeeName;
	@Value("${TestProp}")
	private String test;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("From Setter of Employee Address..");
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

	public void display() {
		System.out.println("\nEmployee Details are:");
		System.out.println("Employee ID:" + this.employeeId);
		System.out.println("Employee Salaray:" + this.salary);
		System.out.println("\nAddress line1:" + this.address.getAddressLine1());
		System.out.println("Address line2:" + this.address.getAddressLine2());
		System.out.println("Test Prop: "+test);
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + ", employeeId=" + employeeId
				+ ", salary=" + salary + ", employeeName=" + employeeName + 
				"= test="+test+"]";
	}
	
}