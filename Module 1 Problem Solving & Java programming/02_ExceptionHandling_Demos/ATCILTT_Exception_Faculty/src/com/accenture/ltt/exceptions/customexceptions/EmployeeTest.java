package com.accenture.ltt.exceptions.customexceptions;

import java.util.Scanner;

public class EmployeeTest {

	public static void findEmp(int index) throws EmployeeDoesNotExistException {
		String names[] = { "tom", "jack", "mike" };
		if (index < 0 || index > 2) {
			throw new EmployeeDoesNotExistException("Employee does not exist");
		}
		System.out.println(names[index]);
	}

	public static void main(String[] args) throws EmployeeDoesNotExistException {

		System.out.println("Enter index [1-5] to find emp name");

		try (Scanner sc = new Scanner(System.in);) {

			int index = sc.nextInt();
			findEmp(index);

		}
	}
}
