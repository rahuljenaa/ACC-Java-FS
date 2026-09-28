package com.accenture.ltt.dao;

import com.accenture.ltt.businessbean.DepartmentBean;
import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeDAO {
	
	public Integer insertEmployeeAndDepartment(EmployeeBean employee, EmployeeBean employee2, DepartmentBean d) throws Exception;
	public void removeEmployeeAndDepartment(EmployeeBean employee) throws Exception;
	
	
}
