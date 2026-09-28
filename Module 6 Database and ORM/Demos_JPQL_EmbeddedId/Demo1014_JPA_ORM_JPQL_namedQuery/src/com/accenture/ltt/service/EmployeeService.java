package com.accenture.ltt.service;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	public List<EmployeeBean> retrieveEmployeeDetailsWithInSalaryRange1(Double lowerBound,Double upperBound) throws Exception;
}
