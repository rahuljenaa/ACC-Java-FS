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
			employeeEntity.setEmployeeName(employee.getEmployeeName());
			employeeEntity.setRole(employee.getRole());
			employeeEntity.setSalary(employee.getSalary());
			employeeEntity.setInsertTime(employee.getInsertTime());
			System.out.println("EmployeeEntity  before transaction: " + entityManager.contains(employeeEntity));
			entityManager.getTransaction().begin();
			System.out.println("EmployeeEntity  after transaction begin, before persist: "
					+ entityManager.contains(employeeEntity));
			entityManager.persist(employeeEntity);
			System.out.println("EmployeeEntity  after transaction begin, after persist: "
					+ entityManager.contains(employeeEntity));
			entityManager.getTransaction().commit();
			System.out.println("EmployeeEntity  after transaction commit, after persist: "
					+ entityManager.contains(employeeEntity));
			employeeID = employeeEntity.getEmployeeId();
			
			//clearing the entity manager...
			entityManager.clear();
			System.out.println("EmployeeEntity  after clearing entity manager: "
					+ entityManager.contains(employeeEntity));
		
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
