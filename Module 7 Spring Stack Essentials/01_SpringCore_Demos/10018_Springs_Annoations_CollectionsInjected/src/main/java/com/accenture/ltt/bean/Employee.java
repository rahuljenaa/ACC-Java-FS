package com.accenture.ltt.bean;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("empObject")
public class Employee {

	@Value("#{myAddress}")
	private Address address;

	@Value("1001")
	private Integer employeeId;

	@Value("70000")
	private Double salary;

	@Value("MSD")
	private String employeeName;

	/* Collection Properties */

	@Value("#{feedValuesBean.listPropertyFromFeeder}") // List: [apple, boy]
	private List<Object> listProperty;

	@Value("#{feedValuesBean.mapPropertyFromFeeder}") // Map: {tom=tom@gmail.com, mike=mike@gmail.com}
	private Map<Object, Object> mapProperty;

	@Value("#{feedValuesBean.listPropertyFromFeeder[0]}") // apple
	private String name;

	@Value("#{feedValuesBean.mapPropertyFromFeeder[tom]}") // tom@gmail.com
	private String email;

	public List<Object> getListProperty() {
		return listProperty;
	}

	public void setListProperty(List<Object> listProperty) {
		this.listProperty = listProperty;
	}

	public Map<Object, Object> getMapProperty() {
		return mapProperty;
	}

	public void setMapProperty(Map<Object, Object> mapProperty) {
		this.mapProperty = mapProperty;
	}

	/* Collection Properties */

	public Employee() {
		System.out
				.println("From Constructor of Employee: Created the Employee Object and injected the Address Object\n");
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

	public void display() {
		System.out.println("\nEmployee Details are:");
		System.out.println("Employee ID:" + this.employeeId);
		System.out.println("Employee Salaray:" + this.salary);
		System.out.println("Name : " + name);
		System.out.println("Email : " + email);
		System.out.println("\nAddress line1:" + this.address.getAddressLine1());
		System.out.println("Address line2:" + this.address.getAddressLine2());
	}
}