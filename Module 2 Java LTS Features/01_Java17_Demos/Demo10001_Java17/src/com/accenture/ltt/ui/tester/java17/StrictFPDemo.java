package com.accenture.ltt.ui.tester.java17;

public class StrictFPDemo {
    public static void main(String[] args) {
        double result = 0.1 + 0.2;
        // Result will be consistent across all platforms
        System.out.println(result); // Prints 0.30000000000000004 (IEEE 754 standard)
    }
}