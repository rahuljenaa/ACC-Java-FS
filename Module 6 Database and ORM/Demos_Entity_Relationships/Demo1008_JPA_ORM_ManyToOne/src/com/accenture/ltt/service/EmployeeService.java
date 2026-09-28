package com.accenture.ltt.service;

import com.accenture.ltt.businessbean.DepartmentBean;
import com.accenture.ltt.businessbean.EmployeeBean;

public interface EmployeeService {
	public Integer insertEmployeeAndDepartment(EmployeeBean employee1, EmployeeBean employee2, DepartmentBean d) throws Exception;

}
