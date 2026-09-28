package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ltt.bussiness.bean.EmployeeBean;
import com.accenture.ltt.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO employeeDAO;

	public List<EmployeeBean> findAll() {
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();

		Iterable<EmployeeEntity> listEn = employeeDAO.findAll();
		listEn.forEach(entity -> {
			EmployeeBean employee = new EmployeeBean();
			BeanUtils.copyProperties(entity, employee);
			list.add(employee);
		});
		return list;
	}

	public Optional<EmployeeBean> findOne(Integer id) {
		return employeeDAO.findById(id).map(employeeEntity -> {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			return employeeBean;
		});
	}

	public Integer saveEmployee(EmployeeBean employee) {
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntityBean);
		EmployeeEntity en = employeeDAO.save(employeeEntityBean);
		return en.getId();
	}

	public Optional<EmployeeBean> updateEmployee(EmployeeBean employeeBean) {
		return employeeDAO.findById(employeeBean.getId()).map(employeeEntity -> {
			BeanUtils.copyProperties(employeeBean, employeeEntity);
			employeeDAO.save(employeeEntity);
			return employeeBean;
		});
	}

	public Optional<EmployeeBean> deleteEmployee(int employeeId) {
		return employeeDAO.findById(employeeId).map(employeeEntity -> {
			employeeDAO.delete(employeeEntity);
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			return employeeBean;
		});
	}

}
