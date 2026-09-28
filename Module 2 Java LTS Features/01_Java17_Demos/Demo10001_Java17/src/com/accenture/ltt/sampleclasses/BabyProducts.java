package com.accenture.ltt.sampleclasses;

//non-sealed classes can be extended.
public class BabyProducts extends KidsProducts {
	@Override
	public String getProductDescription() {
		return "Its a baby's product";
	}

}
