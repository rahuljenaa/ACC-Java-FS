package com.accenture.ltt.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeFieldValidator implements ConstraintValidator<EmployeeFieldValidationAnnotation, String>{//name of the related annotation
	@Override
	public void initialize(EmployeeFieldValidationAnnotation arg0) { //name of the related annotation
	}
	@Override
	public boolean isValid(String string, ConstraintValidatorContext arg1) {//Validation applied on any String Property
		if(string==null){
			return true;
		}
		if (string.split(" ").length==2||string.split(" ").length==3) {
			return true;
		}else{
			return false;
		}
	}
}
