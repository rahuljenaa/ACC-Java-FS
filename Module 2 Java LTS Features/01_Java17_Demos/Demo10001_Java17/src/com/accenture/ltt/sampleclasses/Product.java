package com.accenture.ltt.sampleclasses;

public sealed abstract class Product permits ElectronicsProducts, KidsProducts, BeautyProducts {
	abstract public String getProductDescription();
}

//Uncomment the below class declaration and observe the error. 
/*class HomeAppliances extends Product {

	@Override
	public String getProductDescription() {
		return "My Product";
	}
	
}*/