package com.dac.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {
	
	@RequestMapping(value="/getStudentAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage() throws IOException {
		
		String exceptionOccured = "NULL_POINTER";
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
//			throw new NullPointerException("Null Pointer Exception");
//			throw new IOException("IO Exception");
			throw new ArithmeticException("Arithmetic Exception");
		}
		
		ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
	 
	
/*	@ExceptionHandler(value = NullPointerException.class)
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

	}*/

}
