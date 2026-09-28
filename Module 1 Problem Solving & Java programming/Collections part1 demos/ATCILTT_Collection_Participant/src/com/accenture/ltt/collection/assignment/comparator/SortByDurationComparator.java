package com.accenture.ltt.collection.assignment.comparator;

import java.util.Comparator;

public class SortByDurationComparator implements Comparator<Course> {

	@Override
	public int compare(Course course1, Course course2) {
		return Integer.compare(course1.getDuration(), course2.getDuration());
	}

}
