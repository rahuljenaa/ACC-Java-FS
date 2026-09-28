package com.accenture.ltt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Employee;

public class TestEmployeeClass {
	
	@Test
	public void testEmployee(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/ltt/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		Assertions.assertTrue(employee!=null);
	}
	
	@Test
	public void testEmployeeSalary(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/accenture/ltt/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");
		Assertions.assertTrue(employee.getSalary()==200000);
	}
}
// draw backs:
//1 for every methods Application context is reload, and support for context management 
// and caching is not there

//2 in current approach, in case of transaction failure, no support to perform selective rollback/commit
// it has to be done manually