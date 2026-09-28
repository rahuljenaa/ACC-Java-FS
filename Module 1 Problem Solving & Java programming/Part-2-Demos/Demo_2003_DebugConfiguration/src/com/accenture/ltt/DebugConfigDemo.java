package com.accenture.ltt;
public class DebugConfigDemo {

    public static void main(String[] args) {

        // Step 1: Open Eclipse → Run → Debug Configurations...
        // Step 2: Select "Java Application" → Click "New Configuration"
        // Step 3: In Main tab → Browse and select this class (DebugConfigDemo) as Main Class
        // Step 4: (Optional) Add Program Arguments, e.g., "Ravi 50000"
        // Step 5: Enable "Stop in main()" to pause at the first line of execution
        // Step 6: Click Apply → Debug → Program pauses before executing first statement

        System.out.println("Debug Configuration Demo Started");

        //  Step 7: Inspect Variables View after program starts
        String name = "Ravi";
        double salary = 50000;

        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);

        double bonus = calculateBonus(salary);

        System.out.println("Final Salary (with Bonus): " + (salary + bonus));

        System.out.println("Debug Configuration Demo Completed");
    }

    //  Step 8: Step Into this method using Debug Controls to see how call stack changes
    public static double calculateBonus(double salary) {
        double bonus = salary * 0.10;
        return bonus;
    }
}
