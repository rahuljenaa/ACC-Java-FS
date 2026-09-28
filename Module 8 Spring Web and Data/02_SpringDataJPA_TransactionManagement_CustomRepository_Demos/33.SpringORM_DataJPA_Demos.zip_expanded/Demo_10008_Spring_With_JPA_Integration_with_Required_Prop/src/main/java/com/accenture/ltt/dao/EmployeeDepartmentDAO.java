package com.accenture.ltt.dao;

import com.accenture.ltt.business.bean.DepartmentBean;
import com.accenture.ltt.business.bean.EmployeeBean;

public interface EmployeeDepartmentDAO {

	Integer addEmployee(EmployeeBean employeeBean) throws Exception;

	Integer addDepartment(DepartmentBean departmentBean) throws Exception;

}