package com.accenture.ltt.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Employee {

	private Address address;
	private Integer employeeId;
	private Double salary;
	private String employeeName;
	
	/*Collection Properties*/
	private  List<Object>listProperty;
	private  Set<Object>setProperty;
	private  Map<Object,Object>mapProperty;
	private  Properties propertiesProperty;	
	
	public List<Object> getListProperty() {
		return listProperty;
	}

	public void setListProperty(List<Object> listProperty) {
		this.listProperty = listProperty;
	}

	public Set<Object> getSetProperty() {
		return setProperty;
	}

	public void setSetProperty(Set<Object> setProperty) {
		this.setProperty = setProperty;
	}

	public Map<Object, Object> getMapProperty() {
		return mapProperty;
	}

	public void setMapProperty(Map<Object, Object> mapProperty) {
		this.mapProperty = mapProperty;
	}

	public Properties getPropertiesProperty() {
		return propertiesProperty;
	}

	public void setPropertiesProperty(Properties propertiesProperty) {
		this.propertiesProperty = propertiesProperty;
	}


	/*Collection Properties*/
	

	
	
	public Employee(Address address) {
		this.address = address;
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
	}
}