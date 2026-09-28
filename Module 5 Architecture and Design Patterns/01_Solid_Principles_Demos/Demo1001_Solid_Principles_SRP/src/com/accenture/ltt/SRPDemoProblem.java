package com.accenture.ltt;
//This Employee class is violating SRP
//Because it handles Salary Calculation, Reporting, and Database operations
class Employee {

	//Salary related responsibility
    public void calculatePay() {
        System.out.println("Calculating employee pay...");
    }
    //Reporting logic should not be in Employee class
    public void reportEmployee() {
        System.out.println("Generating employee report...");
    }
    //Database logic also should not be in Employee class
    public void saveToDatabase() {
        System.out.println("Saving employee details to database...");
    }
}

public class SRPDemoProblem {
    public static void main(String[] args) {
        Employee emp = new Employee();
        //Employee class doing too many task
        emp.calculatePay();
        emp.reportEmployee();
        emp.saveToDatabase();
    }
}

