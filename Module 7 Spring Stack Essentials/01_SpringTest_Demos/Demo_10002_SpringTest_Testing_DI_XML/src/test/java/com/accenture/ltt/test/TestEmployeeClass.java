package com.accenture.ltt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Test
	public void testEmployeeSalary(){
		Assertions.assertTrue(employee.getSalary()==200000);
	}
}
//https://docs.spring.io/spring-batch/trunk/reference/html/testing.html
//https://blogs.oracle.com/javamagazine/post/migrating-from-junit-4-to-junit-5-important-differences-and-benefits
//https://docs.spring.io/spring/docs/4.2.4.RELEASE/spring-framework-reference/htmlsingle/#testing-introduction