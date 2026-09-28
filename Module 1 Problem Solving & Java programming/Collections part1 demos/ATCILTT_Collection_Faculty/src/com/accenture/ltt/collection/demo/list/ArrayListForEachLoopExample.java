package com.accenture.ltt.collection.demo.list;

import java.util.ArrayList;

public class ArrayListForEachLoopExample {
	public static void main(String[] args) {
		// Create an ArrayList to store names of employees.
		ArrayList<String> empNames = new ArrayList<>();
		empNames.add("John");
		empNames.add("Riya");
		empNames.add("Ram");
		empNames.add("Ali");
		empNames.add("Jess");
		// Iterate ArrayList using for-each loop
		for (String name : empNames) {
			System.out.println(name);
		}
	}
}
