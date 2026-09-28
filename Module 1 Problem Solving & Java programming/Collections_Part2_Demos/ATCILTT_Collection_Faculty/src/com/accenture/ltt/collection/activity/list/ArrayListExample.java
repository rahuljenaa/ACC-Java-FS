package com.accenture.ltt.collection.activity.list;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// Create an ArrayList to total marks scored by students.
		ArrayList<Integer> studentMarks = new ArrayList<>();
		studentMarks.add(87);
		studentMarks.add(98);
		studentMarks.add(80);
		studentMarks.add(68);
		studentMarks.add(52);
		//Print the marks
		System.out.println(studentMarks);
	}
}