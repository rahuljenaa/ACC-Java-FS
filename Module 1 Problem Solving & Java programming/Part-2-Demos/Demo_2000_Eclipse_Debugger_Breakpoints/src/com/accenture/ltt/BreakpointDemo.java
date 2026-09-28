// Demo_20001_Eclipse_Debugger_Breakpoints
// Demonstrates Line, Conditional, Exception, Method, and Class Load Breakpoints.
package com.accenture.ltt;
public class BreakpointDemo {

    //  Step 1: Set a CLASS LOAD BREAKPOINT here
    static {
        System.out.println("Class BreakpointDemo loaded into memory");
    }

    public static void main(String[] args) {
        System.out.println("=== Demo: All Types of Breakpoints ===");

        //  Step 2: Set a LINE BREAKPOINT on the next line
        int[] numbers = {2, 4, 6, 8, 10};

        for (int i = 0; i < numbers.length; i++) {

            // Step 3: Add a CONDITIONAL BREAKPOINT -> Condition: i == 2
            System.out.println("Processing index: " + i + " -> Value: " + numbers[i]);

            if (numbers[i] == 8) {
                //  Step 4: Trigger an EXCEPTION BREAKPOINT for NullPointerException
                throw new NullPointerException("Simulated Exception at value: " + numbers[i]);
            }
        }

        // 🟢 Step 5: Add a METHOD BREAKPOINT on sortNumbers()
        sortNumbers();
        System.out.println("Program Completed.");
    }

    public static void sortNumbers() {
        System.out.println("Inside sortNumbers() method.");
        int[] nums = {5, 1, 3, 2, 4};
        java.util.Arrays.sort(nums);
        System.out.println("Sorted Numbers: " + java.util.Arrays.toString(nums));
    }
}
