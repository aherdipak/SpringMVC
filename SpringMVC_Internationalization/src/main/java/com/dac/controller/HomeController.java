package com.dac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/getAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage() {
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
	
}
