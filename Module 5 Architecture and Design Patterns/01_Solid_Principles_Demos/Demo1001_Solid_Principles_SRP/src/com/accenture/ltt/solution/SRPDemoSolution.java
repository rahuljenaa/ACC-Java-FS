package com.accenture.ltt.solution;

//This class now only handles Salary related responsibility
class Employee {
	
	public void calculatePay() {
        System.out.println("Calculating employee pay...");
    }

}

//Separate class to handle reporting duty
class EmployeeReport {
	public void generateReport() {
        System.out.println("Generating employee report...");
    }
}
//Separate class for database operations
class EmployeeRepository {

	public void saveToDatabase() {
        System.out.println("Saving employee details to database...");
    }
}

public class SRPDemoSolution {

	public static void main(String[] args) {
		//Each class has only one responsibility
		Employee employee = new Employee();
        EmployeeReport report = new EmployeeReport();
        EmployeeRepository repository = new EmployeeRepository();

        employee.calculatePay();// Handles only salary
        report.generateReport();   // Handles reporting
        repository.saveToDatabase(); // Handles DB tasks

	}

}
