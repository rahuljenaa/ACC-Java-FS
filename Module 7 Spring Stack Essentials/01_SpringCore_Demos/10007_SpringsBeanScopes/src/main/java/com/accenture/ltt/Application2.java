package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Employee;

public class Application2 {

	public static void main(String[] args) {
		
		// 1st Time
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean2.xml");
		Employee employee1 = (Employee) applicationContext.getBean("empObject");

		System.out.println("\nPlease check the HashCodes of Address Object");
		System.out.println("=========================");
		System.out.println(employee1);
		System.out.println(employee1.getAddress());

		// 2nd Time
		Employee employee2 = (Employee) applicationContext.getBean("empObject1");
		System.out.println(employee2);
		System.out.println(employee2.getAddress());
	}

}
