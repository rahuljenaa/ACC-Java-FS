package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.entity.EmployeeEntity;
import com.accenture.ltt.exceptions.EmployeeNotFoundException;

@Repository
@Transactional("txManager")
public class EmployeeDAOWrapperImpl {

	@Autowired
	private EmployeeDAO employeeDao;

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		Integer employeeID = 0;

		EmployeeEntity employeeEntityBean = convertBeanToEntity(employeeBean);
		try {
			employeeEntityBean = employeeDao.save(employeeEntityBean);

			employeeID = employeeEntityBean.getId();
		} catch (Exception exception) {
			throw exception;
		}

		return employeeID;
	}

	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		EmployeeBean employeeBean = null;
		try {
			Optional<EmployeeEntity> employeeEntity = employeeDao.findById(id);
			EmployeeEntity employeeEntity1 = employeeEntity.get();
			employeeBean = convertEntityToBean(employeeEntity1);
		} catch (NoSuchElementException e) {
			throw new EmployeeNotFoundException();
		} catch (Exception ex) {
			throw ex;
		}
		return employeeBean;
	}

	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		EmployeeBean employeeBean2 = null;
		try {
			Optional<EmployeeEntity> employeeEntityBean2 = employeeDao.findById(employeeBean.getId());
			EmployeeEntity employeeEntityBean = employeeEntityBean2.get();
			employeeEntityBean.setInsertTime(employeeBean.getInsertTime());
			employeeEntityBean.setName(employeeBean.getName());
			employeeEntityBean.setRole(employeeBean.getRole());
			employeeEntityBean.setSalary(employeeBean.getSalary());

			employeeBean2 = convertEntityToBean(employeeEntityBean);
		} catch (NoSuchElementException e) {
			throw new EmployeeNotFoundException();
		} catch (Exception ex) {
			throw ex;
		}
		return employeeBean2;
	}

	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception {
		EmployeeBean employeeBean = null;
		try {
			Optional<EmployeeEntity> employeeEntity = employeeDao.findById(id);
			EmployeeEntity employeeEntityBean = employeeEntity.get();
			employeeDao.delete(employeeEntityBean);

			employeeBean = convertEntityToBean(employeeEntityBean);
		} catch (NoSuchElementException e) {
			throw new EmployeeNotFoundException();
		} catch (Exception ex) {
			throw ex;
		}
		return employeeBean;
	}

	public List<EmployeeBean> getEmployeeList() throws Exception {
		List<EmployeeBean> listEmployeeBean = null;
		try {
			listEmployeeBean = new ArrayList<EmployeeBean>();

			List<EmployeeEntity> listEmployeeEntity = (List<EmployeeEntity>) employeeDao.findAll();

			for (EmployeeEntity entity : listEmployeeEntity) {
				EmployeeBean emp = convertEntityToBean(entity);
				listEmployeeBean.add(emp);
			}

		} catch (Exception exception) {
			throw exception;
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
