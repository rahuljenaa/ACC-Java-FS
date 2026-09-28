package com.accenture.ltt.dao;

import com.accenture.ltt.businessbean.EmployeeBean;

import java.util.List;

public interface EmployeeDAO {

    /**
     * Insert a new employee into MongoDB
     * @param bean EmployeeBean object to insert
     * @return 1 if success, 0 if failure
     */
    int insertEmployee(EmployeeBean bean);

    /**
     * Read all employees from MongoDB
     * @return List of EmployeeBean
     */
    List<EmployeeBean> readEmployee();

    /**
     * Update an existing employee in MongoDB
     * @param bean EmployeeBean object containing updated values
     */
    void updateEmployee(EmployeeBean bean);

    /**
     * Delete an employee from MongoDB
     * @param bean EmployeeBean object containing employeeID to delete
     */
    void deleteEmployee(EmployeeBean bean);
}
