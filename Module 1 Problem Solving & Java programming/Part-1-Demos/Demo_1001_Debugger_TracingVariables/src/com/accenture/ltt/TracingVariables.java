package com.accenture.ltt;

//Demo 1: Syntax vs Runtime vs Logical Error
//HOW TO USE:
//1) Start with the SYNTAX ERROR section: uncomment the bad line to show a compile-time error, then fix it.
//2) Run the RUNTIME ERROR: observe ArithmeticException (division by zero), then fix 'b' to non-zero.
//3) Run the LOGICAL ERROR: observe wrong sum, use println tracing to find and fix the bug.

public class TracingVariables {
 public static void main(String[] args) {
     System.out.println("=== Demo 1: Syntax vs Runtime vs Logical Error ===");

     // ---------- SYNTAX ERROR (Compile-time) ----------
     // Uncomment the next line to PRODUCE a syntax error (missing semicolon):
     // int x = 10  // ❌ Missing semicolon -> compiler error
     // Fix: add semicolon -> int x = 10;

     // ---------- RUNTIME EXCEPTION (Execute-time) ----------
     int a = 10;
     int b = 0; // ❌ Will cause division by zero
     try {
         System.out.println("Runtime test: a / b = " + (a / b));
     } catch (ArithmeticException ex) {
         System.out.println("Caught ArithmeticException: " + ex.getMessage());
         // Fix suggestion: set b = 2; then rerun
     }

     // ---------- LOGICAL ERROR (Program runs but wrong output) ----------
     // Goal: sum the first 5 numbers (1..5 = 15). Bug: starts from 0 and uses '<' wrong bound.
     int sum = 0;
     for (int i = 0; i <5; i++) { // ❌ Off-by-one logic if intended 1..5 (prints 10)
         // TRACE with println to see i and sum
         System.out.println("[TRACE] i=" + i + ", sum(before)+=i -> " + sum + " + " + i);
         sum += i;
     }
     System.out.println("Logical error result (expected 15): " + sum);
     // Fix: for (int i = 1; i <= 5; i++) sum += i;
 }
}
