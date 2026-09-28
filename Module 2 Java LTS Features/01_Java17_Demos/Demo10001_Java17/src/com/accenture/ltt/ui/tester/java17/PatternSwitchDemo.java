package com.accenture.ltt.ui.tester.java17;
public class PatternSwitchDemo {
    public static void main(String[] args) {
        // Creating an Object that holds a String value
        // We use Object type to show how pattern matching works with different possible types
        Object obj = "Java 17";

        /*
         * Pattern Matching in switch (Java 17 preview feature)
         * ----------------------------------------------------
         * - You can match both the type AND the value in a single switch case.
         * - The syntax 'case Type variable ->' checks if obj is an instance of 'Type'
         *   and automatically casts it to that type.
         */
        String result = switch (obj) {
            // If obj is a String, cast to 's' and convert it to uppercase
            case String s -> "It's a string: " + s.toUpperCase();

            // If obj is an Integer, cast to 'i' and multiply by 2
            case Integer i -> "Integer value: " + (i * 2);

            // If obj is neither String nor Integer, handle it in the default case
            default -> "Unknown type";
        };

        // Printing the result based on the matched case
        System.out.println(result);
    }
}