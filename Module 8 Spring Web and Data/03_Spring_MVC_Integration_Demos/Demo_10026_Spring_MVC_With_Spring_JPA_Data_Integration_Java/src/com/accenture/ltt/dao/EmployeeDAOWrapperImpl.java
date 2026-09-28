package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.entity.EmployeeEntity;

@Repository
@Transactional("txManager")
public class EmployeeDAOWrapperImpl {

	@Autowired
	private EmployeeDAO employeeDAO;

	public Integer addEmployee(EmployeeBean employeeBean) {
		Integer employeeID = 0;
		EmployeeEntity employeeEntityBean = convertBeanToEntity(employeeBean);
		employeeEntityBean = employeeDAO.save(employeeEntityBean);
		employeeID = employeeEntityBean.getId();
		return employeeID;
	}

	public Optional<EmployeeBean> getEmployeeDetails(Integer id) {
		return employeeDAO.findById(id).map(entity -> convertEntityToBean(entity));
	}

	public Optional<EmployeeBean> updateEmployeeDetails(EmployeeBean employeeBean) {
		return employeeDAO.findById(employeeBean.getId()).map(employeeEntity -> {
			employeeEntity = convertBeanToEntity(employeeBean);
			employeeDAO.save(employeeEntity);
			return employeeBean;
		});
	}

	public Optional<EmployeeBean> deleteEmployeeDetails(int employeeId) {
		return employeeDAO.findById(employeeId).map(employeeEntity -> {
			employeeDAO.delete(employeeEntity);
			EmployeeBean employeeBean = convertEntityToBean(employeeEntity);
			return employeeBean;
		});
	}

	public List<EmployeeBean> getEmployeeList() {
		List<EmployeeBean> listEmployeeBean = null;
		listEmployeeBean = new ArrayList<EmployeeBean>();
		List<EmployeeEntity> listEmployeeEntity = (List<EmployeeEntity>) employeeDAO.findAll();
		for (EmployeeEntity entity : listEmployeeEntity) {
			EmployeeBean emp = convertEntityToBean(entity);
			listEmployeeBean.add(emp);
		}
		return (listEmployeeBean);
	}

	public static EmployeeBean convertEntityToBean(EmployeeEntity entity) {
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}

	public static EmployeeEntity convertBeanToEntity(EmployeeBean bean) {
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(bean, employeeEntityBean);
		return employeeEntityBean;
	}
}
