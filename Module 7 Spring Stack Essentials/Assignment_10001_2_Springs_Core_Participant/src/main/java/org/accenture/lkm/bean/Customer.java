package org.accenture.lkm.bean;

public class Customer {

	private Integer customerId;
	private String customerType;
	private String customerName;

	private Address address;
	
	/*
	 * POA 9 : Annotate with required annotation to inject product object and it should be marked as optional dependency injection
	 */
	private Product product;

	public Customer(){
		
	}
	
	public Customer(Integer customerId, String customerType, String customerName, Address address) {
		super();
		this.customerId = customerId;
		this.customerType = customerType;
		this.customerName = customerName;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerType=" + customerType + ", customerName="
				+ customerName + ", address=" + address + ", product=" + product + "]";
	}

	
	
}