package com.accenture.ltt;

/**
 * Demonstrates common String operations in Java.
 */
public class StringDemo {
    public static void main(String[] args) {
        // Creating Strings
        String name = "Alice";
        String greeting = "Hello, " + name;

        // String length
        System.out.println("Length of greeting: " + greeting.length());

        // Concatenation
        String fullName = "Alice" + " " + "Smith";
        System.out.println("Full Name: " + fullName);

        // Comparison
        String s1 = "hello";
        String s2 = "Hello";
        System.out.println("Equals: " + s1.equals(s2));           // false
        System.out.println("Equals Ignore Case: " + s1.equalsIgnoreCase(s2)); // true

        // Character access
        System.out.println("First char: " + name.charAt(0));

        // Substring
        System.out.println("Substring: " + fullName.substring(0, 5));
    }
}
