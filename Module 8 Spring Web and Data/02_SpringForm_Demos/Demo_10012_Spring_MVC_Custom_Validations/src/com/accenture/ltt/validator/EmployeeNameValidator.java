package com.accenture.ltt.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeNameValidator implements ConstraintValidator<EmployeeNameValidatorVal, String>{//name of the related annotation
	@Override
	public boolean isValid(String employeeName, ConstraintValidatorContext arg1) {
		//Validation Logic
		if(employeeName==null){
			return false;
		}
		if ((employeeName.split(" ").length==3)||(employeeName.split(" ").length==2)) {
			return true;
		}else{
			return false;
		}
	}
}



