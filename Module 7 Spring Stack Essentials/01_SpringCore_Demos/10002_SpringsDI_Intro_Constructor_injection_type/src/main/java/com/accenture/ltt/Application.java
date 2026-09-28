package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Contact;

public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean.xml");
		Contact primaryContact = (Contact) applicationContext.getBean("primaryContact");
		System.out.println(primaryContact);
	}

}
