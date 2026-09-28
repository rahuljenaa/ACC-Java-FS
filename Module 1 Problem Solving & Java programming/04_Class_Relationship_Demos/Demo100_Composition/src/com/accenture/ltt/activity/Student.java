package com.accenture.ltt.activity;

public class Student {
    private String studentName;
    private Course course;

    public Student() {
    	//Create a object of Course and invoke setters to set the values
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }
}
