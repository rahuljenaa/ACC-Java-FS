package com.accenture.ltt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.accenture.ltt.bean.Employee;
import com.accenture.ltt.resources.MyConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=MyConfiguration.class)
public class TestEmployeeClass {
	
	@Autowired
	private Employee employee;
	
	@Test
	public void testEmployee(){
		Assertions.assertTrue(employee!=null);
	}
	
	@Test
	public void testEmployeeSalary(){
		Assertions.assertTrue(employee.getSalary()==100000);
		
	}
	
	@Test
	public void testEmployeeName(){
		Assertions.assertTrue(employee.getEmployeeName().equals("JAS"));
	}
}
//https://docs.spring.io/spring-batch/trunk/reference/html/testing.html
//https://docs.spring.io/spring/docs/4.2.4.RELEASE/spring-framework-reference/htmlsingle/#testing-introduction