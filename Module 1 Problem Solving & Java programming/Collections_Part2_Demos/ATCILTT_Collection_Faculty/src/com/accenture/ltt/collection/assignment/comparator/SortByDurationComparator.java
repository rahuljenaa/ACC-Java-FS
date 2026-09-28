package com.accenture.ltt.collection.assignment.comparator;

import java.util.Comparator;

public class SortByDurationComparator implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		return o1.getCourseDurationInHours()-o2.getCourseDurationInHours();			
		
	}

}
