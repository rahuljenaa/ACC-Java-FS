package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Contact;
import com.accenture.ltt.bean.Employee;

public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean.xml");
		Employee employee = (Employee) applicationContext.getBean("emp");
		System.out.println("\n\n\nOutput is :");
		System.out.println(employee);
	}

}
