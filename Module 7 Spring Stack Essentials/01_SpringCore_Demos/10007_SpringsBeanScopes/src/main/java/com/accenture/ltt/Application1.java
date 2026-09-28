package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Employee;

public class Application1 {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean1.xml");
	
		System.out.println("Please check the HashCodes");
		System.out.println("=========================");
		
		// 1st Time
		Employee employee = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee);

		// 2nd Time
		Employee employee2 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee2);

		// 3rd Time
		Employee employee3 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee3);

		// 4th Time
		Employee employee4 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee4);

		// 5th Time
		Employee employee5 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee5);

		// 6th Time
		Employee employee6 = (Employee) applicationContext.getBean("empObject");
		System.out.println(employee6);
	}

}
