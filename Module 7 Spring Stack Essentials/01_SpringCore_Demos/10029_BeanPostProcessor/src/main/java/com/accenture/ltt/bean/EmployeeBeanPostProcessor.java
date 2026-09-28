package com.accenture.ltt.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EmployeeBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("6. postProcessAfterInitialization");
		if (bean instanceof Employee) {
			Employee e = (Employee) bean;
			if (e.getLastName() == null)
				e.setLastName("Fatima");
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("3. postProcessBeforeInitialization");
		return bean;
	}

}
