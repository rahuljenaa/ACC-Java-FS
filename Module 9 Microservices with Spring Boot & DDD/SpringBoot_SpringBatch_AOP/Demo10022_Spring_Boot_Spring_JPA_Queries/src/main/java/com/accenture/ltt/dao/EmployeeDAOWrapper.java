package com.accenture.ltt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ltt.business.bean.Employee;
import com.accenture.ltt.entity.EmployeeEntity;
@Service
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	// Query Methods:
	public List<Employee> getAllEmployeeFromDepartmentGTSalary(Integer department,double salary){
		List<EmployeeEntity> listEmployee= employeeDAO.findByDepartmentCodeAndSalaryGreaterThanEqual(department, salary);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	
	public List<Employee> getEmployeeDetailsOrderByDepartmentcodedesc(){
		List<EmployeeEntity> listEmployee= employeeDAO.findAllByOrderByDepartmentCodeDesc();
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	public List<Employee> findByEmployeeNameContainingOrderByDepartmentCodeDesc(String pattern){
		List<EmployeeEntity> listEmployee= employeeDAO.findByEmployeeNameContainingOrderByDepartmentCodeDesc(pattern);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	
	public List<Employee> findByDepartmentCodeGreaterThanEqualAndLessThanEqual(Integer param1, Integer param2){
		List<EmployeeEntity> listEmployee= employeeDAO.findByDepartmentCodeGreaterThanEqualAndDepartmentCodeLessThanEqual(param1,param2);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	public List<Employee> findByDepartmentBetween(Integer param1, Integer param2){
		List<EmployeeEntity> listEmployee= employeeDAO.findByDepartmentCodeBetween(param1, param2);
		List<Employee> listEmployeeDTO = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : listEmployee) {
			 Employee employee2 = new Employee();
			 BeanUtils.copyProperties(employeeEntity, employee2);
			 listEmployeeDTO.add(employee2);
		}
		return listEmployeeDTO;
	}
	
	public List<String> getAllEmployeesBySalary(Double salary){
		return employeeDAO.getAllEmployeesBySalary(salary);
	}
	
	@SuppressWarnings("rawtypes")
	public List getDeptCodesAndCountOfEmployee(){
		return employeeDAO.getDeptCodesAndCountOfEmployee();
	}
	
	public Integer updateEmpName(String employeeName,Integer empId){
		return employeeDAO.updateEmployeeName(employeeName, empId);
	}
}
