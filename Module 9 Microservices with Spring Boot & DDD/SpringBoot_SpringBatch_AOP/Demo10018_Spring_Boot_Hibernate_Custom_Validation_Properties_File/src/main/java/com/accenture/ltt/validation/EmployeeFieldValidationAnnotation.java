package com.accenture.ltt.validation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = EmployeeFieldValidator.class)
@Target( { ElementType.FIELD })// Describes the placement of  the annotation whether it can come at instance variable or method level
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeFieldValidationAnnotation {
	String message() default "Value should have 2 or 3 words"; // default message to display on validation failure
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}