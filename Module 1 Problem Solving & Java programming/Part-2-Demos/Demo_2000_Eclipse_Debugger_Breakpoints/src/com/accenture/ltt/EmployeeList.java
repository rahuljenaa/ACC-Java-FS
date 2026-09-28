// Demo_20001_Eclipse_Debugger_Breakpoints
// Demonstrates Line and Conditional Breakpoints in a collection loop.
package com.accenture.ltt;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    public static void main(String[] args) {
        System.out.println("=== Demo: Employee List Debugging ===");

        //  Step 1: Observe List creation in Variables View
        List<String> employees = new ArrayList<>();
        employees.add("Ravi");
        employees.add("Meena");
        employees.add("Karthik");
        employees.add("Divya");

        //  Step 2: Set a LINE BREAKPOINT inside the loop below
        for (int i = 0; i < employees.size(); i++) {
            String name = employees.get(i);

            //  Step 3: Add a CONDITIONAL BREAKPOINT -> Condition: name.equals("Meena")
            System.out.println("Employee " + (i + 1) + ": " + name);

            if (name.equals("Meena")) {
                System.out.println(name + " is a Team Lead");
            }
        }

        System.out.println("After loop execution: " + employees);
        System.out.println("Demo Completed.");
    }
}
