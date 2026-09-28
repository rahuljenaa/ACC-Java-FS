package org.accenture.lkm.bean;

/*
 * POA 5 : Annotate the class with required annotation to make a Product class a spring managed bean 
 * and create an object with beanId named product1
 */
public class Product {

	/*
	 * POA 6: Annotate with required annotation to read and inject the value of property named productId from product.properties file
	 */
	private int productId;
	
	/*
	 * POA 7: Annotate with required annotation to read and inject the value of property named productName from product.properties file
	 */
	private String productName;
	
	/*
	 * POA 8: Annotate with required annotation to read and inject the value of property named price from product.properties file
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
