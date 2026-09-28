package com.accenture.ltt.business.bean;

import javax.validation.constraints.NotNull;

import org.accenture.lkm.validator.OrderStatusValidator;

public class OrderBean {
	private Integer orderId;
	@OrderStatusValidator(message = "{OrderStatusValidator.orderBean.status}")
	private String status;
	/*
	 * POA 18: Annotate the productName property with the respective JSR annotation so that productName cannot be empty/blank
	 * 		message can be inject using key NotEmpty.orderBean.productName from ValidationMessages.properties file 
	 */
	private String productName;
	/*
	 * POA 19: Annotate the quantity property with the respective JSR annotation so that quantity cannot be null
	 * 		also Annotate with the respective JSR annotation so that quantity is in range of 1 to 10
	 * 		messages can be inject using key NotNull.orderBean.quantity and Size.orderBean.quantity from ValidationMessages.properties file 
	 */
	private Integer quantity;
	@NotNull(message = "{NotNull.orderBean.billAmount}")
	private Double billAmount;
	
	public OrderBean() {
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
}
