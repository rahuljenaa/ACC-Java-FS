package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.ltt.bean.Employee;
import com.accenture.ltt.resources.MyConfiguration;

public class Application2 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MyConfiguration.class);
		
		Employee employee = (Employee) applicationContext.getBean("createEmployee");
		employee.display();
	}

}
//Both employee and  address instance will get created
// as we are trying to get access to createEmployee bean