package com.accenture.ltt;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.business.bean.DepartmentBean;
import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.service.EmployeeDepartmentService;

public class Application {
	public static void main(String[] args) {
		EmployeeDepartmentService employeeService=null;
		try{
			
			ApplicationContext applicationContext = 
					new ClassPathXmlApplicationContext("com/accenture/ltt/resources/cst-main-config.xml");
			employeeService = (EmployeeDepartmentService) applicationContext.getBean("employeeDepartmentServiceImpl");

			// 1 Add Employee
			addEmployeeAndDepartment(employeeService);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void addEmployeeAndDepartment(EmployeeDepartmentService serviceImpl) {

		EmployeeBean bean = new EmployeeBean();
		bean.setInsertTime(new Date());
		bean.setName("New Employee");
		bean.setRole("Sr.Analyst");
		bean.setSalary(10.0);
		
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartmentName("Check");
		departmentBean.setDescription("CheckDescription");
		
		try {

			int id = serviceImpl.addEmployeeAndDepartment(bean,departmentBean);
			System.out.println("Employee Registered Successfully: " + id);
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
