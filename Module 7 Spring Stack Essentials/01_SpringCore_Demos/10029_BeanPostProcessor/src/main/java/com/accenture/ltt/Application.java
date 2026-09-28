package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Employee;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean.xml");
		Employee employee = context.getBean(Employee.class);
		System.out.println(employee);
		
	
	}
}