package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.business.bean.EmployeeBean;

public interface EmployeeService {
	EmployeeBean addEmployee(EmployeeBean bean)throws Exception;

	List<EmployeeBean> getAllEmployeeDetails()throws Exception;

}
