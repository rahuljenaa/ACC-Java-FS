package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.entity.EmployeeEntity;

@Service
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO employeeDAO;

	public int addEmployee(EmployeeBean employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		EmployeeEntity emp = employeeDAO.save(employeeEntity);
		return emp.getEmployeeId();
	}

	public Collection<EmployeeBean> getEmployeeDetails() {
		Collection<EmployeeEntity> employeeEntities = employeeDAO.findAll();
		List<EmployeeBean> employeeBeans = new ArrayList<>();
		for (EmployeeEntity employeeEntity : employeeEntities) {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			employeeBeans.add(employeeBean);
		}
		return employeeBeans;
	}

	public Optional<EmployeeBean> getEmployeeDetailByEmployeeId(int employeeId) { 
		Optional<EmployeeBean> employeeBeanResult = employeeDAO.findById(employeeId).map(employeeEntity -> {
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			return employeeBean;
		});
		return employeeBeanResult;
	}

	public Optional<EmployeeBean> deleteEmployee(int employeeId) {
		Optional<EmployeeBean> employeeBeanResult = employeeDAO.findById(employeeId).map(employeeEntity -> {
			employeeDAO.delete(employeeEntity);
			EmployeeBean employeeBean = new EmployeeBean();
			BeanUtils.copyProperties(employeeEntity, employeeBean);
			return employeeBean;
		});
		return employeeBeanResult;
	}

	public Optional<EmployeeBean> updateEmployee(EmployeeBean employeeBean) {
		Optional<EmployeeBean> employeeBeanResult = employeeDAO.findById(employeeBean.getEmployeeId()).map(employeeEntity->{
			 BeanUtils.copyProperties(employeeBean,employeeEntity);
			 employeeDAO.save(employeeEntity);
			 return employeeBean;
			 });
		return employeeBeanResult;
	}

}
