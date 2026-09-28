package com.accenture.ltt.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accenture.ltt.bean.Address;
import com.accenture.ltt.bean.Employee;

@Configuration
public class MyConfiguration {
	
	@Bean
	public Employee createEmployee(Address address){
		Employee  employee = new Employee(address);
		employee.setEmployeeId(101);
		employee.setEmployeeName("JAS");
		employee.setSalary(100000.0);
		return  employee;
	}

	@Bean(name="address")
	public Address createAddress(){
		Address address=new Address();
		address.setAddressLine1("HSR Layout, Sector1");
		address.setAddressLine2("Bangalore, Karnatka");
		return address;
	}
}
// if Bean name is not given then the bean is created by the name of the method