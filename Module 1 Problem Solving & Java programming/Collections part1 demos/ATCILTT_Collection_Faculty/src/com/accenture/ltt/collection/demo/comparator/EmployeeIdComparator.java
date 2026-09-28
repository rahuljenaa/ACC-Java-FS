package com.accenture.ltt.collection.demo.comparator;

import java.util.Comparator;

public class EmployeeIdComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {
		if (o1.getEmployeeId() > o2.getEmployeeId())
			return 1;
		else if (o1.getEmployeeId() < o2.getEmployeeId())
			return -1;
		else
			return 0;
	}
}