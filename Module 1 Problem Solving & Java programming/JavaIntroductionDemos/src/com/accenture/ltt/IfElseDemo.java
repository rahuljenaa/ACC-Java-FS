package com.accenture.ltt;

/**
 * Demonstrates if-else control structure in Java.
 */
public class IfElseDemo {
    public static void main(String[] args) {
        int number = 10;

        // Check if number is positive, negative, or zero
        if (number > 0) {
            System.out.println("Positive number");
        } else if (number < 0) {
            System.out.println("Negative number");
        } else {
            System.out.println("Zero");
        }
    }
}