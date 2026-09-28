package com.accenture.ltt.tight.coupling;

class Employee {

	private Address address;
	private Integer employeeId;
	private Double salary;

	public Employee() {
		this.address = new Address();
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

	public void display() {
		System.out.println("Employee Details are:");
		System.out.println("Employee ID" + this.employeeId);
		System.out.println("Employee Salaray" + this.salary);
		System.out.println("Address line1:" + this.address.getAddressLine1());
		System.out.println("Address line2:" + this.address.getAddressLine2());
	}
}