package com.accenture.ltt;

import com.accenture.ltt.looselycoupled.Address;
import com.accenture.ltt.looselycoupled.Employee;
import com.accenture.ltt.looselycoupled.PostalAddress;

public class Application {

	public static void main(String[] args) {
		Address address = new Address();
		Employee employee = new Employee(address);
		
		Address address1 = new PostalAddress();
		Employee employee2 = new Employee(address1);
	}

}
