package com.dac.custom.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{

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
	// Custom annotation always makes a call  isValid function to its corresponding Validator class 
	// but we want to notice that before makes a call to isValid function custom annotaion always make sure call to initialize() function of currespnoding validator class

}