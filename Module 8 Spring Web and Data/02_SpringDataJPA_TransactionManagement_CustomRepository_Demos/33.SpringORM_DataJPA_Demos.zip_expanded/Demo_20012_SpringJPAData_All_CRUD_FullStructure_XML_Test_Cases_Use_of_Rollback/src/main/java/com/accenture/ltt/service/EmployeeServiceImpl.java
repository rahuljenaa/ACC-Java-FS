package com.accenture.ltt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.EmployeeBean;
import com.accenture.ltt.dao.EmployeeDAOWrapper;
import com.accenture.ltt.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private  EmployeeDAOWrapper employeeDAOWrapper;

		public  EmployeeBean addEmployee(EmployeeBean bean)throws Exception{
			return employeeDAOWrapper.addEmployee(bean);
		}
		public EmployeeBean getEmployeeDetails(Integer id)throws Exception{
			Optional<EmployeeBean> employeeBean = employeeDAOWrapper.getEmployeeDetails(id);
			return employeeBean.orElseThrow(() -> new EmployeeNotFoundException());
		}
		public List<EmployeeBean> getAllEmployeeDetails()throws Exception{
			return employeeDAOWrapper.getAllEmployeeDetails();
		}
		public void deleteEmployee(EmployeeBean bean)throws Exception{
			employeeDAOWrapper.deleteEmployee(bean);
		}
}
