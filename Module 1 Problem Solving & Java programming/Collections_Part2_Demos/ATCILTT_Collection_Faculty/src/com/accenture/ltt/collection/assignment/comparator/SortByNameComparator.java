package com.accenture.ltt.collection.assignment.comparator;

import java.util.Comparator;

public class SortByNameComparator implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		return o1.getCourseName().compareTo(o2.getCourseName());
			
		
	}

}
