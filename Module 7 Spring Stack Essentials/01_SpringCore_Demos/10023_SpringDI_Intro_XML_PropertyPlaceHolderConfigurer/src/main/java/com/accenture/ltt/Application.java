package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Employee;

public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean.xml");
		Employee emp= (Employee)ctx.getBean("employee");
		System.out.println(emp);
	}
}
//Tell about Annotations
//Tell about the ${} vs #{}