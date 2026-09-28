package com.accenture.ltt.collection.assignment.comparator;

public class Course {

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

}
