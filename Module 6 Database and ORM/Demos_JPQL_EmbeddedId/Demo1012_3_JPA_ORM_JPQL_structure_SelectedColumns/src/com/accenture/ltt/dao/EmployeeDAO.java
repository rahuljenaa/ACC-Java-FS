package com.accenture.ltt.dao;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	public List<String> retrieveEmployeeNames() throws Exception;
	public List<EmployeeBean> retrieveEmployeeIdAndNameColumns() throws Exception;
}
