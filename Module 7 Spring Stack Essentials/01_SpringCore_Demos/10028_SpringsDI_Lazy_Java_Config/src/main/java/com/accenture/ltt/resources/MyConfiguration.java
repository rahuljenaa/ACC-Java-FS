package com.accenture.ltt.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.accenture.ltt.bean.Address;
import com.accenture.ltt.bean.Employee;

@Configuration
@Lazy(value=true)
public class MyConfiguration {

	//@Lazy(value = true)// even if not mentioned by default it is Laszy true as mentioned
	@Bean
	public Employee createEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId(1001);
		employee.setEmployeeName("Jack");
		employee.setSalary(1900.0);
		Address address = createAddress();
		employee.setAddress(address);
		return employee;
	}

	@Lazy(value = false)  
	// on the configuration
	@Bean(name = "address")
	public Address createAddress() {
		Address address = new  Address();
		address.setAddressLine1("AddressLine1");
		address.setAddressLine2("AddressLine2");
		return address ;
	}
}
