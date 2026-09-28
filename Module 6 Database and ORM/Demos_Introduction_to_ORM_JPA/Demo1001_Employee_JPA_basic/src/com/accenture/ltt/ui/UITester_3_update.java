package com.accenture.ltt.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.accenture.ltt.entity.EmployeeEntity;

public class UITester_3_update {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, 1004);
		if (employeeEntity != null) {
			entityManager.getTransaction().begin();
			employeeEntity.setSalary(150000.00);
			entityManager.getTransaction().commit();
			System.out.println("Employee updated successfully!!");
		} else {
			System.out.println("Employee is not found!!");
		}
		entityManager.close();
		entityManagerFactory.close();
	}
}
