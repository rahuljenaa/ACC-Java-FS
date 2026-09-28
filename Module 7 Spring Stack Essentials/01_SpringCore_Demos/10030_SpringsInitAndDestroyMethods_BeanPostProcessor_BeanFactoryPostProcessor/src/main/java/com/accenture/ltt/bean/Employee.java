package com.accenture.ltt.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {
	private String firstName;
	private String lastName;

	public Employee() {
		System.out.println("2. constructor");
	}

	// setter and getter methods
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("3. setter");
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("5. postConstruct()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6. afterPropertiesSet()");
	}

	public void init() {
		System.out.println("7. init()");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("9. preDestroy");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("10 DisposableBean");

	}

	public void destroyMethod() {
		System.out.println("11. destroy-method");
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}