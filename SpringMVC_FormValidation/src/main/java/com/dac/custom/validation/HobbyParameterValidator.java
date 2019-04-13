package com.dac.custom.validation;

import javax.validation.ConstraintValidatorContext;

public class HobbyParameterValidator {

public void initialize(IsValidHobby isValidHobby) {
		
	}

	public boolean isValid(String studentHobby, ConstraintValidatorContext context) {
		if(studentHobby == null) {
			return false;
		}
		
		if(studentHobby.matches("Music|Football|Cricket|Hockey")) {
			return true;
		}else {
			return false;
		}
	}
	
}
