package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.CompanyBean;
import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	public Integer createCompanyAndEmployeeRecords(CompanyBean companyBean1,EmployeeBean employeeBean1,EmployeeBean employeeBean2) throws Exception ;
	void deleteCompanyAndEmployeeRecords(CompanyBean companyBean)
			throws Exception;
}
