package com.accenture.ltt;


//Demo 4: Reading Stack Trace & Isolating Error
//
//PURPOSE: Trigger NullPointerException, read stack trace, then fix via null check.
//STEPS:
//1) Run as-is -> observe NPE stack trace pointing to getLength(name).
//2) Add a null-check in getLength before calling length().

public class StackTraceAndFix {
 public static void main(String[] args) {
     System.out.println("=== Demo 4: Stack Trace & Isolating Error ===");
     String name = null; // ❌ Intentional null to trigger NPE
     try {
         int len = getLength(name); // Stack trace will point here and into getLength
         System.out.println("Name length = " + len);
     } catch (NullPointerException ex) {
         ex.printStackTrace(); // Print full stack trace to console
         System.out.println("Fix: add null-check in getLength().");
     }
 }

 static int getLength(String s) {
     // ❌ This will throw NPE when s is null
     return s.length();
     // Fix:
     // if (s == null) return 0;
     // return s.length();
 }
}
