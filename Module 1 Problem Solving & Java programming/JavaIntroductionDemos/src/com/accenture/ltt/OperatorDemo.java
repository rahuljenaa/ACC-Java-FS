package com.accenture.ltt;

/**
 * Demonstrates various Java operators.
 */
public class OperatorDemo {
    public static void main(String[] args) {
        int a = 10, b = 5;

        // Arithmetic operators
        System.out.println("Addition: " + (a + b));         // 15
        System.out.println("Multiplication: " + (a * b));   // 50

        // Relational operator
        System.out.println("Is a > b? " + (a > b));         // true

        // Logical operator
        System.out.println("Logical AND: " + (a > 5 && b < 10)); // true
    }
}