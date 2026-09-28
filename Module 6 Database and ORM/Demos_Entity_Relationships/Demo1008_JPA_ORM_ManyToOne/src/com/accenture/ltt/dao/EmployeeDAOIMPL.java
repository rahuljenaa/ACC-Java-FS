package com.accenture.ltt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.accenture.ltt.businessbean.DepartmentBean;
import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.entity.DepartmentEntity;
import com.accenture.ltt.entity.EmployeeEntity;
import com.accenture.ltt.utility.JPAUtility;

public class EmployeeDAOIMPL implements EmployeeDAO {

	@Override
	public Integer insertEmployeeAndDepartment(EmployeeBean employee1, EmployeeBean employee2, DepartmentBean d)
			throws Exception {
		EntityManager entityManager = null;
		int employeeId = 0;
		try {
			EntityManagerFactory entityManagerFactory = JPAUtility.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();

			DepartmentEntity dEntity = convertDepartmentBeanToEntity(d);
			EmployeeEntity e1 = convertEmployeeBeanToEntity(employee1);
			EmployeeEntity e2 = convertEmployeeBeanToEntity(employee2);

			e1.setDepartment(dEntity);
			e2.setDepartment(dEntity);

			entityManager.getTransaction().begin();
			entityManager.persist(e1);
			entityManager.persist(e2);
			entityManager.getTransaction().commit();
			employeeId = e1.getEmployeeId();
		} catch (Exception exception) {
			throw exception;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return employeeId;
	}

	
	
	public static DepartmentEntity convertDepartmentBeanToEntity(DepartmentBean departmentBean) {
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setDepartmentName(departmentBean.getDepartmentName());
		departmentEntity.setCity(departmentBean.getCity());
		return departmentEntity;
	}

	public static EmployeeEntity convertEmployeeBeanToEntity(EmployeeBean employeeBean) {
		EmployeeEntity e1 = new EmployeeEntity();
		e1.setEmployeeName(employeeBean.getEmployeeName());
		e1.setRole(employeeBean.getRole());
		return e1;
	}
}
