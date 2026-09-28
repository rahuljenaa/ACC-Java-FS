package com.accenture.ltt.ui;

import java.util.Date;
import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.service.EmployeeServiceImpl;
import com.accenture.ltt.utility.DBUtility;

public class Tester {

    private static EmployeeService service = new EmployeeServiceImpl();

    public static void main(String[] args) {

        // Call individual CRUD methods
         //   insertEmployee(1001, "Alice", "Sr Analyst", 50000.0);
        //   insertEmployee(1002, "Bob", "Sr Analyst", 45000.0);

         //  readEmployees();

        //   updateEmployeeSalary(1001, 55000.0);

           deleteEmployee(1002);

       
    }

    // ----------------- CRUD METHODS -----------------

    public static void insertEmployee(int id, String name, String role, double salary) {
        EmployeeBean emp = new EmployeeBean();
        emp.setEmployeeID(id);
        emp.setEmployeeName(name);
        emp.setRole(role);
        emp.setSalary(salary);
        emp.setInsertTime(new Date());

        service.insertEmployee(emp);
        System.out.println("Inserted Employee: " + id);
    }

    public static void readEmployees() {
        List<EmployeeBean> employees = service.readEmployee();
        System.out.println("\nAll Employees:");
        for (EmployeeBean e : employees) {
            System.out.println(e.getEmployeeID() + " - " + e.getEmployeeName() + " - " 
                               + e.getRole() + " - " + e.getSalary());
        }
    }

    public static void updateEmployeeSalary(int id, double newSalary) {
        EmployeeBean emp = new EmployeeBean();
        emp.setEmployeeID(id);
        emp.setSalary(newSalary);

        service.updateEmployee(emp);
        System.out.println("\nUpdated Salary for Employee ID: " + id);
    }

    public static void deleteEmployee(int id) {
        EmployeeBean emp = new EmployeeBean();
        emp.setEmployeeID(id);

        service.deleteEmployee(emp);
        System.out.println("\nDeleted Employee ID: " + id);
    }
}
