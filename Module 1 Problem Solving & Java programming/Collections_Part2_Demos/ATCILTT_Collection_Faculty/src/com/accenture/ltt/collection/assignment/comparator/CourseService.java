package com.accenture.ltt.collection.assignment.comparator;

import java.util.Collections;
import java.util.List;

public class CourseService {
	
	//Method which helps to print courses sorted based on course fee

	
	public void printAllCoursesFeesSorted(List<Course> courses) {
		//Sort the collection by calling Collections.sort method
		Collections.sort(courses,new SortByFeesComparator());
		//Print course name and fee using foreach method
		courses.stream().forEach(x->System.out.println("Course is "+x.getCourseName()+" "
				+ ": Course Fee is Rs." +x.getCourseFee()));
	}
	public void printAllCoursesNamesSorted(List<Course> courses) {
		//Sort the collection by calling Collections.sort method
		Collections.sort(courses,new SortByNameComparator());
		//Print course name and fee using foreach method
		courses.stream().forEach(x->System.out.println("Course is "+x.getCourseName()+" "
				+ ": Course Fee is Rs." +x.getCourseFee()));
	}public void printAllCoursesDurationSorted(List<Course> courses) {
		//Sort the collection by calling Collections.sort method
		Collections.sort(courses,new SortByDurationComparator());
		//Print course name and fee using foreach method
		courses.stream().forEach(x->System.out.println("Course is "+x.getCourseName()+" "
				+ ": Course Fee is Rs." +x.getCourseFee()));
	}
	
	
}
