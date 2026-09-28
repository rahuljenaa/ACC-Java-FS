package com.accenture.ltt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.ltt.entity.EmployeeEntity;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Integer> {

}
