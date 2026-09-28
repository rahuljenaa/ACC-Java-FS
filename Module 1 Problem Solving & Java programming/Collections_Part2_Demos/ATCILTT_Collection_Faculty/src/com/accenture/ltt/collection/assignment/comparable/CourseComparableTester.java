package com.accenture.ltt.collection.assignment.comparable;

import java.util.ArrayList;
import java.util.List;

public class CourseComparableTester {

	public static void main(String[] args) {
		//ArrayList to store transaction objects
		List<Course> courses = new ArrayList<>();
		
		//Create courses and add them to the ArrayList
		Course t1 = new Course(1056, "C#.Net", 72, 20000);
		courses.add(t1);

		Course t2 = new Course(1045, "Java", 48, 15000);
		courses.add(t2);

		Course t3 = new Course(4532, "Python", 40, 20500);
		courses.add(t3);

		//Call print method of service class which prints
		CourseService service = new CourseService();
		service.printAllCoursesSorted(courses);
		

	}
}
