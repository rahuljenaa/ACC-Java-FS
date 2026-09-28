package org.accenture.lkm.bean;

/*
 * POA 3 : Annotate the class with required annotation to make a Product class a spring managed bean 
 * and create an object with beanId named product
 */
public class Product {

	/*
	 * POA 4: Annotate with required annotation to set the productId value as 1001
	 */
	private int productId;
	
	/*
	 * POA 5: Annotate with required annotation to set the productName value as WashingMachine
	 */
	private String productName;
	
	/*
	 * POA 6: Annotate with required annotation to set the price value as 45000.0
	 */
	private double price;
	
	public Product() {
		
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	
}
