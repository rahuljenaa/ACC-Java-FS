package com.accenture.ltt;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Employee;

public class Application {

	public static void main(String[] args) {
		// 1st Time
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("empObject");

		employee.display();

		applicationContext.close();

	}

}
// @autowire and @value doesnot works with the static variables and methods
