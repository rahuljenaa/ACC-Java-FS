package com.accenture.ltt;

import java.util.Date;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.entity.EmployeeEntityBean;
import com.accenture.ltt.exceptions.EmployeeNotFoundException;
import com.accenture.ltt.resources.JavaConfig;

public class Application {

	public static void main(String[] args) {
		EmployeeDAO employeeDAOIMPL = null;
		try {

			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
			employeeDAOIMPL = (EmployeeDAO) applicationContext.getBean("employeeDAO");

			// 1 Add Employee
			// addEmployee(employeeDAOIMPL);

			// 2 Get Employee Employee
			 getEmployeeDetails(employeeDAOIMPL);

			// 3 Update Employee
			// updateEmployeeDetails(employeeDAOIMPL);

			// 4 Delete Employee
			// deleteEmployee(employeeDAOIMPL);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addEmployee(EmployeeDAO daoimpl) {
		EmployeeEntityBean bean = new EmployeeEntityBean();
		bean.setInsertTime(new Date());
		bean.setName("Test New Employee");
		bean.setRole("Sr.Analyst");
		bean.setSalary(220.0);
		try {
			int id = daoimpl.save(bean).getId();
			System.out.println("Employee Registered Successfully: " + id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getEmployeeDetails(EmployeeDAO daoimpl) {
		int empId = 1002;
		try {
			EmployeeEntityBean employeeEntityBean = daoimpl.findById(empId)
					.orElseThrow(() -> new EmployeeNotFoundException());
			System.out.println("Employee Details");
			System.out.println("================");
			System.out.println("Name: " + employeeEntityBean.getName());
			System.out.println("Salary: " + employeeEntityBean.getSalary());
			System.out.println("Role: " + employeeEntityBean.getRole());
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateEmployeeDetails(EmployeeDAO daoimpl) {
		int empId = 1002;
		try {
			EmployeeEntityBean employeeEntityBean = daoimpl.findById(empId)
					.orElseThrow(() -> new EmployeeNotFoundException());
			employeeEntityBean.setSalary(1235.4);
			daoimpl.save(employeeEntityBean); // save the updates back
			System.out.println("Updated Employee Details");
			System.out.println("========================");
			System.out.println("Name: " + employeeEntityBean.getName());
			System.out.println("Salary: " + employeeEntityBean.getSalary());
			System.out.println("Role: " + employeeEntityBean.getRole());
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteEmployee(EmployeeDAO daoimpl) {
		int empId = 1002;
		try {
			EmployeeEntityBean employeeEntityBean = daoimpl.findById(empId)
					.orElseThrow(() -> new EmployeeNotFoundException());
			daoimpl.delete(employeeEntityBean);
			System.out.println("Employee Deleted successfully sith employeeId: " + employeeEntityBean.getId());
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
