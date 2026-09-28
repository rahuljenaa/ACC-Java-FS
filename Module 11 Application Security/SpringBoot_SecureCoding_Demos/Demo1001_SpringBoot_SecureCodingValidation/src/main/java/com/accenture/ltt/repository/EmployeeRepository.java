package com.accenture.ltt.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.ltt.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Derived query method – safe parameter binding
	Employee findByEmployeeId(Integer employeeId);

	// Explicit JPQL using named parameter – safe
	@Query("SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
	Employee findByEmployeeIdUsingQuery(@Param("employeeId") Integer employeeId);

	// Native query example – still safe if using parameter binding
	@Query(value = "SELECT * FROM employees WHERE employee_id = :employeeId", nativeQuery = true)
	Employee findByEmployeeIdNative(@Param("employeeId") Integer employeeId);
}

