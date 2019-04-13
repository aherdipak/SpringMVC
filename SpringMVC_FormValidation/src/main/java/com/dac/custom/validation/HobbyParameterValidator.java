package com.dac.custom.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyParameterValidator implements ConstraintValidator<IsValidParameterHobby, String>{

	// IF WE WANT ANNOTATION ACCEPT INT PARAMETER THEN DECLARE INT AS DATATYPE HERE,
	//OR IF WE WANT STRING THEN DECLARE STRING AS A DATATYPE
	private String listOfValidHobbies;
	
	
	public void initialize(IsValidParameterHobby isValidHobby) {
		this.listOfValidHobbies = isValidHobby.listOfValidHobbies();
	}
	
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		
		if(studentHobby == null) {
			return false;
		}
		
		if(studentHobby.matches(listOfValidHobbies)) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
