package org.accenture.lkm.resources;

import org.accenture.lkm.bean.Address;
import org.accenture.lkm.bean.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
/*
 * POA 13: Annotate with required annotation to make all the bean object creation in this configuration class as LAZY
 * POA 14: Annotate with required annotation to include the ReaderConfig configuration class
 * POA 15: Annotate with required annotation to scan the package org.accenture.lkm.bean for all stereotype annotations
 */
public class MyConfiguration {

	
	/*
	 * POA 16: Annotate the method with required annotation to make bean as Spring managed with name "customer1"
	 * POA 17: The address parameter of the method will report exception NoUniqueBeanDefinitionException fix it with required annotation
	 */
	public Customer createCustomer(Address address) {
		Customer customer = new Customer();
		customer.setCustomerId(1001);
		customer.setCustomerName("JAS");
		customer.setCustomerType("Platnium");
		customer.setAddress(address);
		return customer;
	}

	@Bean(name = "address1")
	public Address createAddress1() {
		Address address = new  Address();
		address.setAddressLine1("AddressLine1");
		address.setAddressLine2("AddressLine2");
		return address ;
	}
	@Bean(name = "address2")
	public Address createAddress2() {
		Address address = new  Address();
		address.setAddressLine1("AddressLine3");
		address.setAddressLine2("AddressLine4");
		return address ;
	}
}
