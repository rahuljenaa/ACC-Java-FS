package com.accenture.ltt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreateEmployeeRequest {

	@NotBlank(message = "employee name is required")
	@Size(min = 2, max = 100, message = "employee name must be 2-100 characters")
	private String employeeName;

	@NotNull(message = "employee ID is required")
	@Positive(message = "employee ID must be positive")
	private Integer employeeId;

	@NotNull(message = "salary is required")
	@Positive(message = "salary must be positive")
	private double salary;

	@NotNull(message = "department code is required")
	@Positive(message = "department code must be positive")
	private Integer departmentCode;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
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
}

