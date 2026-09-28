package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	public List<String> retrieveEmployeeNames() throws Exception;
	public List<EmployeeBean> retrieveEmployeeIdAndNameColumns() throws Exception;
}
