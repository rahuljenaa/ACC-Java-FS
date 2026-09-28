package com.accenture.ltt.java8features;

public class DefaultMethodImpl1 implements IDefaultMethodOne, IDefaultMethodTwo {

	//Duplicate default methods named print with the parameters () and () are inherited from the types IDefaultMethodTwo and IDefaultMethodOne
		
	@Override
	public void print() {
		
		IDefaultMethodOne.super.print();  // change to IDefaultMethodTwo.super.print()
	}

	
	
	

	
}
