package com.accenture.llt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.llt.entity.EmployeeEntity;

public interface EmployeeDAO  extends JpaRepository<EmployeeEntity, Integer>{

}
