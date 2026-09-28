// Demo_20001_Eclipse_Debugger_Breakpoints
// Demonstrates Exception and Method Breakpoints for debugging practice.
package com.accenture.ltt;
public class DebugPractice {

    public static void main(String[] args) {
        System.out.println("=== Demo: Exception & Method Breakpoints ===");

        // Step 1: Set an EXCEPTION BREAKPOINT for ArithmeticException
        try {
            int result = divide(10, 0); // Intentional division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // Step 2: Add a METHOD BREAKPOINT on greetUser()
        greetUser("Ravi");

        System.out.println("Program Completed.");
    }

    public static int divide(int a, int b) {
        // Step 3: Step Into this method to observe the call stack
        System.out.println("Dividing " + a + " by " + b);
        return a / b; // Will cause ArithmeticException
    }

    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "! Welcome to the Debugger Demo.");
    }
}
