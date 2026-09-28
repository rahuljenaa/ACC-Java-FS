package com.accenture.ltt.activity;

public class Manager extends Employee {

    // Additional instance variable
    int numberOfReportees;

    // Getter method
    public int getNumberOfReportees() {
        // return numberOfReportees;
        return 0; // placeholder
    }

    // Setter method
    public void setNumberOfReportees(int numberOfReportees) {
        // this.numberOfReportees = numberOfReportees;
    }

    // Overriding printEmployeeDetails method
    @Override
    public void printEmployeeDetails() {
        // Call super.printEmployeeDetails();
        // Print numberOfReportees here
    }
}
