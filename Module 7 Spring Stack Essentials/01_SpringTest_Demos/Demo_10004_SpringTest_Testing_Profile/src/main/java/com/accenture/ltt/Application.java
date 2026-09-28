package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.ltt.bean.Employee;
import com.accenture.ltt.resources.MyConfiguration;

public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "myProfile");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Employee employee = (Employee) applicationContext.getBean("empObject");
		employee.display();
	}

}
