package com.dac.custom.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyParameterValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidParameterHobby {
	
	
	// IF WE WANT ANNOTATION ACCEPT INT PARAMETER THEN DECLARE INT AS DATATYPE HERE,
	//OR IF WE WANT STRING THEN DECLARE STRING AS A DATATYPE
	
	String listOfValidHobbies();
	
	String message() default "Please provide a valid Hobby; "+
	"accepted hobbies are - Music, Football, Cricket and Hockey (choose anyone)";
	 Class<?>[] groups() default {};
	 Class <? extends Payload>[] payload() default {};

}
