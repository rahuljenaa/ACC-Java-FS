package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.ltt.bean.Employee;
import com.accenture.ltt.resources.MyConfiguration;

public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class); // change to MyConfiguration2  and taste
		Employee employee = (Employee) ctx.getBean("createEmployee");
		employee.display();
		
	}
}
