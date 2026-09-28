package org.accenture.lkm.business.bean;

public class CustomerBean {
	
	private Integer customerId;
	private String customerName;
	private String customerType;
	private double billAmount;
	
	
	public CustomerBean(Integer customerId, String customerName,String customerType,double billAmount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerType = customerType;
		this.billAmount = billAmount;
	}
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
