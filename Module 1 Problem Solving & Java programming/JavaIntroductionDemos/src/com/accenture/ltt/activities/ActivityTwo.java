package com.accenture.ltt.activities;

/**
 * TODO: Implement a calculator that performs +, -, *, / operations using switch.
 */
public class ActivityTwo {
    public static void main(String[] args) {
        double a = 20;
        double b = 5;
        char operator = '*'; // Try with '-', '*', '/'

        // TODO: Use switch-case to perform operation
        // Output the result

        switch (operator) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            default:
                System.out.println("Please enter a valid operator");
                break;
        }
    }
}
