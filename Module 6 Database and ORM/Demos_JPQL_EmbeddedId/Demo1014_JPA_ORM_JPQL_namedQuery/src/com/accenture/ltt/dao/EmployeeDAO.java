package com.accenture.ltt.dao;

import java.util.List;

import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	public List<EmployeeBean> retrieveEmployeeDetailsWithInSalaryRange(Double lowerBound,Double upperBound) throws Exception;
}
