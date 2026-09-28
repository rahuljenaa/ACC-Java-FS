package com.accenture.ltt.ui.tester.java17;

import com.accenture.ltt.sampleclasses.BabyProducts;
import com.accenture.ltt.sampleclasses.BeautyProducts;
import com.accenture.ltt.sampleclasses.ElectronicsProducts;
import com.accenture.ltt.sampleclasses.KidsProducts;
import com.accenture.ltt.sampleclasses.Product;

//Make sure JRE compliance pointing to JRE17.
// If not, enable preview feature from Eclipse -> Right click to Project -> Build path -> Configure build path -> Java Compiler -> Enable project specific settings -> Enable preview features  
public class Tester1001Sealed {
	public static void main(String[] args) {
		Product product;
		product = new BabyProducts();
		//product = new ElectronicsProducts();
		//product = new KidsProducts();
		//product = new BeautyProducts();
		
		String productPescription = getDescription(product);
		System.out.println("Product description: " + productPescription);
	}

	private static String getDescription(Product product) {
		String description = null;
		if(product instanceof BabyProducts babyProduct) {
			description = babyProduct.getProductDescription();
		}
		else if(product instanceof BeautyProducts beautyProduct) {
			description = beautyProduct.getProductDescription();
		}
		else if(product instanceof ElectronicsProducts electronicsProduct) {
			description =  electronicsProduct.getProductDescription();
		}
		else if(product instanceof KidsProducts kidsProduct) {
			description = kidsProduct.getProductDescription();
		}
		else {
			description = "Invalid product";
		}
		
		return description;
	}
}