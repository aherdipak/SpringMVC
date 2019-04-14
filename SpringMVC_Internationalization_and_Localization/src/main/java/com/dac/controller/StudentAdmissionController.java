package com.dac.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dac.beans.Student;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/getAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage() {
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
	
	   
		@RequestMapping(value="/submitStudentAdmissionForm.htm", method=RequestMethod.POST)
		public ModelAndView submitStudentAdmissionForm(@Valid @ModelAttribute("student") Student student, BindingResult result) {
			
			//TO CHECK ERROR IS PRESENT, IF PRESENT THEN SIMPLY RETURN SAME FORM WITH ERROR DESCRIPTION BACK TO USER
			if(result.hasErrors()) {
				ModelAndView modelAndView = new ModelAndView("admissionForm");
				return modelAndView;
			}
			
			ModelAndView modelAndView = new ModelAndView("admissionSuccess");
			
			modelAndView.addObject("headerMsg", "Enginnering College,India");
			modelAndView.addObject("msg", "Form Submitted by Name: "+ student.getStudentName() +" Hobby: "+student.getStudenthobby());
			
			return modelAndView;
		}
	
}
