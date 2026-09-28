package com.accenture.ltt;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    public static void main(String[] args) {
        System.out.println("Runtime State Demo Started");

        // Step 1: Observe the List creation and element addition in Variables View
        List<String> employees = new ArrayList<>();
        employees.add("Ravi");
        employees.add("Meena");
        employees.add("Karthik");
        employees.add("Divya");

        // Step 2: Set a Line Breakpoint on the next line to inspect runtime state
        for (int i = 0; i < employees.size(); i++) {

            // Step 3: When paused here, open Variables View
            // Inspect variables: i, employees, name
            String name = employees.get(i);

            System.out.println("Employee " + (i + 1) + ": " + name);

            // Step 4: Conditional logic – monitor this condition in Expressions View
            if (name.equals("Meena")) {
                System.out.println(name + " is a Team Lead");
            }

            //  Step 5 (Optional): While paused, try modifying variable value in Variables View
            // Example: Change name = "Meena Sharma" and resume to see the effect
        }

        //  Step 6: Inspect final state of the List after loop completes
        System.out.println("After loop execution: " + employees);

        //  Step 7: End of demo – verify console output after modifications
        System.out.println("Runtime State Demo Completed");
    }
}
