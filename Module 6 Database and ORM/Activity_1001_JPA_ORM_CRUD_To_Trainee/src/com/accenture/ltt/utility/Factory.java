package com.accenture.ltt.utility;

import com.accenture.ltt.dao.CustomerDAO;
import com.accenture.ltt.dao.CustomerDAOIMPL;
import com.accenture.ltt.service.CustomerService;
import com.accenture.ltt.service.CustomerServiceIMPL;

public class Factory {
	
	public static CustomerDAO createCustomerDAO(){
		return new CustomerDAOIMPL();
	}
	
	public static CustomerService createCustomerService(){
		return new CustomerServiceIMPL();
	}

}
