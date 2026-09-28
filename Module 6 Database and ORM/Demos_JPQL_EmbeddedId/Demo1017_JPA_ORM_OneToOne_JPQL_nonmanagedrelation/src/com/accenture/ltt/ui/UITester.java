package com.accenture.ltt.ui;

import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.utility.Factory;
import com.accenture.ltt.utility.JPAUtility;

public class UITester {

	public static void main(String[] args) {
		try {
			 getAllEmployeesWithAssetDetails();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JPAUtility.closeEntityManagerFactory();
		}

	}

	public static void getAllEmployeesWithAssetDetails() {

		EmployeeService employeeService = Factory.createEmployeeService();
		try {
			 employeeService.getAllEmployeesWithAssetDetails();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
