package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	public List<EmployeeBean> retrieveEmployeeDetails() throws Exception;
	public List<EmployeeBean> retrieveEmployeeDetailsUsingHibernateProvider() throws Exception;
}
