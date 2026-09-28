package com.accenture.ltt.ui;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.utility.Factory;
import com.accenture.ltt.utility.JPAUtility;

public class UITester {

	public static void main(String[] args) {
		try {
			//retrieveEmployeeDetailsWithInSalaryRange1(45000.0,60000.0);
			
			
			retrieveEmployeeDetailsWithInSalaryRange2(45000.0,60000.0);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JPAUtility.closeEntityManagerFactory();
		}

	}

	static public void retrieveEmployeeDetailsWithInSalaryRange1(Double lowerBound, Double upperBound) {
		List<EmployeeBean> employees = null;
		
		EmployeeService employeeService = Factory.createEmployeeService();
		try {
			employees = employeeService.retrieveEmployeeDetailsWithInSalaryRange1(lowerBound,upperBound);
			for(EmployeeBean e: employees) {
				System.out.println(e.getEmployeeId()+","+e.getEmployeeName()+","+e.getRole()+","+e.getSalary());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static public void retrieveEmployeeDetailsWithInSalaryRange2(Double lowerBound, Double upperBound) {
		List<EmployeeBean> employees = null;
		
		EmployeeService employeeService = Factory.createEmployeeService();
		try {
			employees = employeeService.retrieveEmployeeDetailsWithInSalaryRange2(lowerBound,upperBound);
			
			for(EmployeeBean e: employees) {
				System.out.println(e.getEmployeeId()+","+e.getEmployeeName()+","+e.getRole()+","+e.getSalary());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
