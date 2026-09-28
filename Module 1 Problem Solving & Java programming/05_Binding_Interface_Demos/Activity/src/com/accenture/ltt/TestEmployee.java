package com.accenture.ltt;

public class TestEmployee {

    public static void main(String[] args) {

        // Create Employee reference and Manager object
        Employee emp = new Manager();

        // Call calculateSalary() method
        emp.calculateSalary(); // Notice which class’s method is executed

        // Call getBonus() method
        emp.getBonus(); // Notice which class’s method is executed
    }
}

