package com.accenture.ltt.collection.assignment.comparable;

public class Course implements Comparable<Course> {

	private int courseId;
	private String courseName;
	private int courseDurationInHours;
	private int courseFee;

	public Course(int courseId, String courseName, int courseDurationInHours, int courseFee) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDurationInHours = courseDurationInHours;
		this.courseFee = courseFee;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCourseDurationInHours() {
		return courseDurationInHours;
	}

	public int getCourseFee() {
		return courseFee;
	}

	@Override
	public int compareTo(Course o) {
		if (this.getCourseFee() > o.getCourseFee())
			return 1;
		else if (this.getCourseFee() == o.getCourseFee())
			return 0;
		else
			return -1;
	}


}
