package com.accenture.ltt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.entity.EmployeeEntity;
import com.accenture.ltt.utility.JPAUtility;

public class EmployeeDAOIMPL implements EmployeeDAO {

	public Integer addEmployee(EmployeeBean employee) throws Exception {
		// TODO Auto-generated method stub
		Integer employeeID = 0;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerFactory = JPAUtility.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setEmployeeId(employee.getEmployeeId());
			employeeEntity.setEmployeeName(employee.getEmployeeName());
			employeeEntity.setSalary(employee.getSalary());
			entityManager.getTransaction().begin();
			entityManager.merge(employeeEntity);
			entityManager.getTransaction().commit();
			employeeID = employeeEntity.getEmployeeId();
		} catch (Exception exception) {
			throw exception;
			
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return employeeID;
	}


}
