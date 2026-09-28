package com.accenture.ltt;
public class AdvancedDebugDemo {

    // Use a WATCHPOINT on this field to break whenever it is read or written
    private static double bonusRate = 0.10; // Right-click margin → Toggle Watchpoint (field)

    public static void main(String[] args) {
        System.out.println("Advanced Debugging Tools Demo Started");

        Employee e = new Employee("Ravi", 50000);
        applyAnnualIncrement(e);     //Try a METHOD BREAKPOINT here
        applyBonus(e);               //Step Filters can skip into JDK/internal libs

        //DROP TO FRAME: After stepping past applyBonus, use 'Drop to Frame' on main()
        // to re-run from this point and observe state reset.

        System.out.println("Final: " + e);

        // HOT CODE REPLACE (HCR):
        // While paused in debug, edit the body of formatEmployee() to change output
        // and save. Eclipse automatically applies the change using Hot Code Replace.
        // No need to restart the program.
        System.out.println(formatEmployee(e));

        System.out.println("Advanced Debugging Tools Demo Completed");
    }

    private static void applyAnnualIncrement(Employee e) {
        // CONDITIONAL BREAKPOINT / HIT COUNT:
        // Put a breakpoint that hits only when salary > 60000 or after N hits.
        if (e.getSalary() < 60000) {
            e.setSalary(e.getSalary() * 1.10);
        }
    }

    private static void applyBonus(Employee e) {
        // WATCHPOINT will trigger when bonusRate is READ here
        double bonus = e.getSalary() * bonusRate;
        e.setSalary(e.getSalary() + bonus);
    }

    private static String formatEmployee(Employee e) {
        // DETAIL FORMATTER idea: You can configure how Employee is displayed in Variables View
        return "Employee{name='" + e.getName() + "', salary=" + e.getSalary() + "}";
    }

    // ===== Helper Type =====
    static class Employee {
        private String name;
        private double salary; // You can also add a WATCHPOINT on this field

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() { return name; }
        public double getSalary() { return salary; }

        public void setSalary(double salary) {
            // TRACEPOINT alternative: log automatically without pausing (configure from breakpoint properties)
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee(" + name + ", " + salary + ")";
        }
    }
}
