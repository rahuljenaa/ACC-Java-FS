package com.accenture.ltt;

public class DynamicBindingTester {
	public static void main(String[] args){
		Employee manager = new Manager("Cooper",3001,4);
		manager.displayDetails(); //Modify the code to display employee name and employee id
		System.out.println(manager.getEmployeeId());
		System.out.println(manager.getEmployeeName());
		// System.out.println(manager.getNumberOfReportees()); // uncomment and try
		
		
	}
}
