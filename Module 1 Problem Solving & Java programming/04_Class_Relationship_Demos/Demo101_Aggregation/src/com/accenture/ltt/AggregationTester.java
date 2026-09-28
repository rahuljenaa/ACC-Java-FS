package com.accenture.ltt;

public class AggregationTester {
	public static void main(String[] args){
		Department department = new Department();
		department.setDepartmentName("Computer Science");
		

		Faculty faculty = new Faculty();
		faculty.setFacultyId(1001);
		faculty.setFacultyName("Smith");
		department.setFaculty(faculty);
		
		System.out.println("Department Name: " + department.getDepartmentName());
		System.out.println("Faculty Name: " + department.getFaculty().getFacultyName());
		System.out.println("Faculty ID: " + department.getFaculty().getFacultyId());
	}
}
