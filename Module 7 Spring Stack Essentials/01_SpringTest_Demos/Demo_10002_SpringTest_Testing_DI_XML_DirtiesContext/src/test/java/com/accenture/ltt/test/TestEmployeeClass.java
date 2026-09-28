package com.accenture.ltt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.accenture.ltt.bean.Employee;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="/com/accenture/ltt/resources/my_springbean.xml")
public class TestEmployeeClass {
	
	@Autowired
	private Employee employee;
	
	@Test
	public void testEmployee(){
		Assertions.assertTrue(employee!=null);
	}
	
	@DirtiesContext(methodMode=MethodMode.AFTER_METHOD)
	@Test
	public void testEmployeeSalary(){
		System.out.println("********** test employee salary **********");
		Assertions.assertFalse(employee.getSalary()!=200000);
		
	}
	
	@DirtiesContext(methodMode=MethodMode.BEFORE_METHOD)
	@Test
	public void testEmployeeName(){
		System.out.println("********** test employee Name **********");
		Assertions.assertTrue(employee.getEmployeeName().equals("Jack"));
	}
}
//https://docs.spring.io/spring-batch/trunk/reference/html/testing.html
//https://docs.spring.io/spring/docs/4.2.4.RELEASE/spring-framework-reference/htmlsingle/#testing-introduction