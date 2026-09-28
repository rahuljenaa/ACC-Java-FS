package com.accenture.ltt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.Employee;
import com.accenture.ltt.dao.EmployeeDAOWrapper;
@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	public List<Employee> getAllEmployeeFromDepartmentGTSalary(Integer department,double salary){
		return employeeDAOWrapper.getAllEmployeeFromDepartmentGTSalary(department, salary);
	}
	
	public List<Employee> getEmployeeDetailsOrderByDepartmentcodedesc(){
		return employeeDAOWrapper.getEmployeeDetailsOrderByDepartmentcodedesc();
	}
	public List<Employee> findByEmployeeNameContainingOrderByDepartmentCodeDesc(String pattern){
		return employeeDAOWrapper.findByEmployeeNameContainingOrderByDepartmentCodeDesc(pattern);
	}
	
	public List<Employee> findByDepartmentCodeGreaterThanEqualAndLessThanEqual(Integer param1, Integer param2){
		return employeeDAOWrapper.findByDepartmentCodeGreaterThanEqualAndLessThanEqual(param1, param2);
	}
	public List<Employee> findByDepartmentBetween(Integer param1, Integer param2){
		return employeeDAOWrapper.findByDepartmentBetween(param1, param2);
	}
	
	public List<String> getAllEmployeesBySalary(Double salary){
		return employeeDAOWrapper.getAllEmployeesBySalary(salary);
	}
	
	@SuppressWarnings("rawtypes")
	public List getDeptCodesAndCountOfEmployee(){
		return employeeDAOWrapper.getDeptCodesAndCountOfEmployee();
	}
	
	public Integer updateEmpName(String employeeName,Integer empId){
		return employeeDAOWrapper.updateEmpName(employeeName, empId);
	}
}
