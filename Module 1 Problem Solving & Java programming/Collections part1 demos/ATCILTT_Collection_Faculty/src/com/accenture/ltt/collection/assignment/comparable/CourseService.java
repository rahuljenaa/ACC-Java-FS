package com.accenture.ltt.collection.assignment.comparable;

import java.util.Collections;
import java.util.List;

public class CourseService {
	
	//Method which helps to print courses sorted based on course fee

	
	public void printAllCoursesSorted(List<Course> courses) {
		//Sort the collection by calling Collections.sort method
		Collections.sort(courses);
		//Print course name and fee using foreach method
		courses.stream().forEach(x->System.out.println("Course is "+x.getCourseName()+" "
				+ ": Course Fee is Rs." +x.getCourseFee()));
	}
	
	
}
