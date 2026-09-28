package com.accenture.ltt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.ltt.bean.OperatorsBean;

public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/accenture/ltt/resources/my_springbean.xml");
		OperatorsBean operatorsBean = (OperatorsBean) applicationContext.getBean("operatorBean");
		System.out.println(operatorsBean);
		operatorsBean.testElvisTernary();
	}

}
// EL Operators and SPEL