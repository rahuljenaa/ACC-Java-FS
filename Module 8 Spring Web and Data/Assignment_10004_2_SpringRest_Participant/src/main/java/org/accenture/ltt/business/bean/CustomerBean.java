package org.accenture.ltt.business.bean;

import org.accenture.ltt.validator.CustomerTypeValidator;

public class CustomerBean {
	private Integer customerId;
	/*
	 * POA - Point of Action
	 * POA 1: Annotate the customerName property with the respective JSR annotation so that customerName cannot be empty/blank
	 * 		message can be inject using key NotEmpty.customer.customerName from ValidationMessages.properties file 
	 */
	private String customerName;
	
	@CustomerTypeValidator(message = "{CustomerTypeValidator.customer.customerType}")
	private String customerType;
	
	/*
	 * POA 2: Annotate the billAmount property with the respective Hibernate validation annotation so that billAmount is between 10000 to 100000 
	 * 		message can be inject using key Range.customer.billAmount from ValidationMessages.properties file 
	 */
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
