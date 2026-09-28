package com.accenture.ltt.business.bean;

import java.util.Objects;

public class EmployeeBean {
	private String employeeName;
	private Integer employeeId;
	private double salary;
	private Integer departmentCode;

	public EmployeeBean() {
		super();
	}

	public EmployeeBean(String employeeName, Integer employeeId, double salary,
			Integer departmentCode) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.salary = salary;
		this.departmentCode = departmentCode;
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
	public int hashCode() {
		return Objects.hash(departmentCode, employeeId, employeeName, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeBean other = (EmployeeBean) obj;
		return Objects.equals(departmentCode, other.departmentCode) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}	
	
}
