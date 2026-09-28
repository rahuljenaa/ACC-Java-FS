package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.ltt.resources.MyConfiguration;

public class Application1 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MyConfiguration.class);
		
	
	}

}
 
//Only address instance will get created