package com.accenture.ltt.service;

import com.accenture.ltt.business.bean.DepartmentBean;
import com.accenture.ltt.business.bean.EmployeeBean;

public interface EmployeeDepartmentService {

	Integer addEmployeeAndDepartment(EmployeeBean employeeBean,DepartmentBean departmentBean)	throws Exception;

}
