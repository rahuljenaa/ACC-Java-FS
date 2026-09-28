package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Employee;

public class Application2 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("com/accenture/lkm/resources/my_springbean.xml");
		
		Employee employee = (Employee) applicationContext.getBean("empObject");
		employee.display();
	}
}