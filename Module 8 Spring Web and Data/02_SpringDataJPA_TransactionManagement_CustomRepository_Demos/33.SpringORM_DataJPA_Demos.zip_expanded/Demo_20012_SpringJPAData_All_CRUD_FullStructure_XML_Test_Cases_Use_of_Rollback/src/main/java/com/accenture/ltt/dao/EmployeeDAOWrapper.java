package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeBean addEmployee(EmployeeBean bean) throws Exception {
		EmployeeBean result = null;
		try {
			EmployeeEntity employeeEntity = convertEmployeeBeanToEntity(bean);
			EmployeeEntity employeeEntity2 = employeeDAO.save(employeeEntity);
			result = convertEmployeeEntityToBean(employeeEntity2);
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	public Optional<EmployeeBean> getEmployeeDetails(Integer id) throws Exception {
		return employeeDAO.findById(id).map(entity -> convertEmployeeEntityToBean(entity));
	}

	public List<EmployeeBean> getAllEmployeeDetails() throws Exception {
		List<EmployeeBean> resultRet = new ArrayList<EmployeeBean>();
		try {
			List<EmployeeEntity> listEntity = (List<EmployeeEntity>) employeeDAO.findAll();
			for (EmployeeEntity employeeEntity : listEntity) {
				EmployeeBean bean = convertEmployeeEntityToBean(employeeEntity);
				resultRet.add(bean);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return resultRet;
	}

	public void deleteEmployee(EmployeeBean bean) throws Exception {
		EmployeeEntity employeeEntity = convertEmployeeBeanToEntity(bean);
		employeeDAO.delete(employeeEntity);
	}

	public static EmployeeBean convertEmployeeEntityToBean(EmployeeEntity entity) {
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}

	public static EmployeeEntity convertEmployeeBeanToEntity(EmployeeBean bean) {
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(bean, employeeEntityBean);
		return employeeEntityBean;
	}

}
