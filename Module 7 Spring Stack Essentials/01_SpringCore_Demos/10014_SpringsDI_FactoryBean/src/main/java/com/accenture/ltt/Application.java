package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.Tool;

public class Application {

	public static void main(String[] args) {
		try {
			ApplicationContext app = new ClassPathXmlApplicationContext("com/accenture/ltt/resources/my_springbean.xml");
			Tool tol = (Tool) app.getBean("tool");
			System.out.println("\n");
			Tool tol1 = (Tool) app.getBean("tool");
			System.out.println("\n");

			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Done: " + tol);
			System.out.println("Done: " + tol1);

		} catch (Exception excpe) {
			excpe.printStackTrace();
		}

	}

}
// you invoke factory
// factory bean it-self invokes if singleTon and getObject
// inside get object of the factory bean we are using a specific constructor to
// create an object