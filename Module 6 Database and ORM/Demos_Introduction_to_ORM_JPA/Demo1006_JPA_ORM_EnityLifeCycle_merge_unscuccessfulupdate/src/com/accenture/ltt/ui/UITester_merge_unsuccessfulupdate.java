package com.accenture.ltt.ui;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.utility.Factory;
import com.accenture.ltt.utility.JPAUtility;

public class UITester_merge_unsuccessfulupdate {

	public static void main(String[] args) {
		try {
			addEmployee();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JPAUtility.closeEntityManagerFactory();
		}

	}

	static public void addEmployee() {
		int id = 0;
		EmployeeBean bean = new EmployeeBean();
		bean.setEmployeeName("New EMP");
		bean.setEmployeeId(1094);
		bean.setSalary(234.5);
		EmployeeService employeeService = Factory.createEmployeeService();
		try {
			id = employeeService.addEmployee(bean);
			System.out.println("Employee Registered Successfully: " + id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
