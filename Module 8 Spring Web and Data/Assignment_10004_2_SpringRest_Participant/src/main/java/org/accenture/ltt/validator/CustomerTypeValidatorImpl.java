package org.accenture.ltt.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerTypeValidatorImpl implements ConstraintValidator<CustomerTypeValidator, String>{//name of the related annotation
	@Override
	public void initialize(CustomerTypeValidator arg0) { 
	}
	@Override
	public boolean isValid(String customerType, ConstraintValidatorContext arg1) {
		customerType=customerType.toUpperCase();
		switch (customerType) {
		case "PLATNIUM":
			return true;
		case "SILVER":
			return true;
		case "GOLD":
			return true;
		default:
			return false;
		}
	}
}
