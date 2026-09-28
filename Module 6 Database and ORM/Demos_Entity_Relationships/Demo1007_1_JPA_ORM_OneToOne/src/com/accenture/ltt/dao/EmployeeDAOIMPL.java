package com.accenture.ltt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.accenture.ltt.businessbean.AssetBean;
import com.accenture.ltt.businessbean.EmployeeBean;
import com.accenture.ltt.entity.AssetEntity;
import com.accenture.ltt.entity.EmployeeEntity;
import com.accenture.ltt.utility.JPAUtility;

public class EmployeeDAOIMPL implements EmployeeDAO {

	@Override
	public Integer insertAssetWithEmployee(EmployeeBean employeeBean, AssetBean assetBean) throws Exception {
		EntityManager entityManager = null;
		int employeeId = 0;
		try {
			EntityManagerFactory entityManagerFactory = JPAUtility.getEntityManagerFactory();
			entityManager = entityManagerFactory.createEntityManager();
			AssetEntity assetEntity = new AssetEntity();
			assetEntity.setAssetName(assetBean.getAssetName());
			assetEntity.setAssetBrandName(assetBean.getAssetBrandName());
			assetEntity.setValidityYears(assetBean.getValidityYears());
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setEmployeeName(employeeBean.getEmployeeName());
			employeeEntity.setRole(employeeBean.getRole());
			employeeEntity.setSalary(employeeBean.getSalary());
			employeeEntity.setInsertTime(employeeBean.getInsertTime());
			employeeEntity.setAssetEntity(assetEntity);	
			entityManager.getTransaction().begin();
				// try to commit persistence of assetEntity and persist the employee entity
				entityManager.persist(assetEntity);
				entityManager.persist(employeeEntity);
			entityManager.getTransaction().commit();
			employeeId = employeeEntity.getEmployeeId();
	
		} catch (Exception exception) {
			// uncomment the below stack trace to see the error
			//exception.printStackTrace();
			throw exception;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return employeeId;
	}
	
	
	
	
		
}
