package com.accenture.ltt.ui;

import java.util.Date;

import com.accenture.ltt.businessbean.AssetBean;
import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.utility.Factory;
import com.accenture.ltt.utility.JPAUtility;

public class UITester {

	public static void main(String[] args) {
		try {
			
			//insertAssetWithEmployee();
			
			removeEmployeeAndAsset();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JPAUtility.closeEntityManagerFactory();
		}

	}

	static void insertAssetWithEmployee() {
		int employeeId = 0;
		try {
			EmployeeService service = Factory.createEmployeeService();
			EmployeeBean employee = new EmployeeBean();
			employee.setEmployeeName("Rohit");
			employee.setInsertTime(new Date());
			employee.setRole("Sr.Analyst");
			employee.setSalary(200000.00);

			AssetBean asset = new AssetBean();
			asset.setAssetName("Laptop");
			asset.setAssetBrandName("Dell");
			asset.setValidityYears(3);

			employeeId = service.insertAssetWithEmployee(employee, asset);
			System.out.println("Employee inserted successfully!!" + employeeId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	

	static void removeEmployeeAndAsset() {
		try {
			EmployeeService service = Factory.createEmployeeService();
			EmployeeBean employee = new EmployeeBean();
			employee.setEmployeeId(1003);
			service.removeEmployeeAndAsset(employee);
			System.out.println("Employee removed successfully!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
