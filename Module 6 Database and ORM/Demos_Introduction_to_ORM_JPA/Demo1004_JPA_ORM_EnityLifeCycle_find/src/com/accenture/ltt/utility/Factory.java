package com.accenture.ltt.utility;

import com.accenture.ltt.dao.EmployeeDAO;
import com.accenture.ltt.dao.EmployeeDAOIMPL;
import com.accenture.ltt.service.EmployeeService;
import com.accenture.ltt.service.EmployeeServiceImpl;

public class Factory {
	
	public static EmployeeDAO createEmployeeDAO(){
		return new EmployeeDAOIMPL();
	}
	
	public static EmployeeService createEmployeeService(){
		return new EmployeeServiceImpl();
	}

}
