package com.accenture.ltt.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.ltt.entity.EmployeeEntityBean;

public interface EmployeeDAO extends CrudRepository<EmployeeEntityBean, Integer>{
	

}
