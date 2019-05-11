/*package com.dac.exception;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		// logging Null Pointer Exception
		System.out.println("Null Pointer Exception Occured: " + e);
		return "NullPointerException";
	}

	@ExceptionHandler(value = IOException.class)
	public String handleIoException(Exception e) {
		System.out.println("IO Exception Occured: " + e);
		return "IOException";
	}

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		System.out.println("IO unknown Occured: " + e);
		return "Exception";

	}
	
}
*/