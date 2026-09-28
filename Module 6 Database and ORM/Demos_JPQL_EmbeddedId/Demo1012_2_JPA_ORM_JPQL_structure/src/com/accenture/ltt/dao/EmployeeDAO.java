package com.accenture.ltt.dao;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	public List<EmployeeBean> retrieveEmployeeDetails() throws Exception;
	public List<EmployeeBean> retrieveEmployeeDetailsUsingHibernateProvider() throws Exception;
}
