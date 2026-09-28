package com.accenture.ltt.entity;

/*
 * POA 7 : Annotate with the required annotation to make this class as Entity and map to the table named Customer
 */
public class CustomerEntity {
	/*
	 * POA 8 : Annotate with the required annotation to make this as a id field and to auto generate the value 
	 */
	private Integer customerId;
	private String customerName;
	private String customerType;
	private double billAmount;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
}
