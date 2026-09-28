package com.accenture.ltt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ltt.business.bean.DepartmentBean;
import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.entity.DepartmentEntity;
import com.accenture.ltt.entity.EmployeeEntity;
@Repository
public class EmployeeDepartmentDAOImpl implements EmployeeDepartmentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//@Transactional(value = "txManager")
	//@Transactional(value = "txManager",propagation = Propagation.REQUIRED)
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception{
		Integer employeeID = 0;
		EmployeeEntity employeeEntityBean =convertEmployeeBeanToEntity(employeeBean);
		try {
			entityManager.persist(employeeEntityBean);
			employeeID = employeeEntityBean.getId();
		} catch (Exception exception) {
			throw exception;
		}
		return employeeID;
	}
	//@Transactional(value = "txManager")
	//@Transactional(value = "txManager",propagation = Propagation.REQUIRED)
	public Integer addDepartment(DepartmentBean departmentBean)throws Exception {
		Integer departmentCode = 0;
		DepartmentEntity departmentEntityBean =convertDepartmentBeanToEntity(departmentBean);
		try {
			entityManager.persist(departmentEntityBean);
			departmentCode = departmentEntityBean.getDepartmentCode();
		} catch (Exception exception) {
			throw exception;
		}
		return departmentCode;
	}
	
	public static EmployeeBean convertEmployeeEntityToBean(EmployeeEntity entity){
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}
	public static EmployeeEntity convertEmployeeBeanToEntity(EmployeeBean bean){
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(bean,employeeEntityBean);
		return employeeEntityBean;
	}
	
	public static DepartmentBean convertDepartmentEntityToBean(DepartmentEntity entity){
		DepartmentBean departmentBean = new DepartmentBean();
		BeanUtils.copyProperties(entity, departmentBean);
		return departmentBean;
	}
	public static DepartmentEntity convertDepartmentBeanToEntity(DepartmentBean bean){
		DepartmentEntity departmentEntityBean = new DepartmentEntity();
		BeanUtils.copyProperties(bean,departmentEntityBean);
		return departmentEntityBean;
	}



	
	
}
