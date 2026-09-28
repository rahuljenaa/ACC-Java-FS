package com.accenture.ltt.dao;

import com.accenture.ltt.businessbean.CompanyBean;
import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	
	public Integer createCompanyAndEmployeeRecords(CompanyBean companyBean1,EmployeeBean employeeBean1,EmployeeBean employeeBean2) throws Exception ;

	public void deleteCompanyAndEmployeeRecords(CompanyBean companyBean) throws Exception;
	
}
