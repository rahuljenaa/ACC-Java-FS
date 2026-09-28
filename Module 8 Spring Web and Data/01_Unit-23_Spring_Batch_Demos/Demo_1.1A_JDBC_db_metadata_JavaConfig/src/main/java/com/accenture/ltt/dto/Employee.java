package com.accenture.ltt.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private Integer employeeId;
	private String employeeName;
	private String designation;
	private double salary;
	private Date dateOfJoining;
	private Integer departmentCode;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeName, String designation, double salary, Date dateOfJoining,
			Integer departmentCode) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.departmentCode = departmentCode;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation=" + designation
				+ ", salary=" + salary + ", dateOfJoining=" + dateOfJoining + ", departmentCode=" + departmentCode
				+ "]";
	}

}
