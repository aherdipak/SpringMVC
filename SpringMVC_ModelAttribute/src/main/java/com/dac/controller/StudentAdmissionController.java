package com.dac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dac.beans.Student;

@Controller
public class StudentAdmissionController {
	
	@RequestMapping(value="/admissionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm()
	{
		ModelAndView model=new ModelAndView("AdmissionForm");
		//model.addObject("headerMessage", "DAC College of Engineering,India");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student")Student student)
	{
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		//model.addObject("headerMessage", "DAC College of Engineering,India");
		return model;
	}
	
	/*
	 * we have two requestHandler methods & both are putting same object in respective
	 * ModelAndView object i.e headerMessage.
	 * Now springMVC says if you have requirement like this where all requestHandler methods which are
	 * present in the same controller class are putting same kind of object in the respective
	 * ModelAndView object then above way is right way of doing things there is no doubt about it .
	 * ==>But if i give option to write less code & doing more things using @ModelAttribute
	 * 	 annotation on a method 
	 * 
	 * */
	
	@ModelAttribute
	public void addingCommandObjects(Model model)
	{
		model.addAttribute("headerMessage", "DAC College of Engineering,India");
	}
	
	/*
	 * SpringMVC says if you add a method like this in your controller class
	 * which is having @ModelAttribute annotation present on its top. then whatever objects
	 * you would add to its Model object ,SpringMVC would automatically add that object 
	 * to the ModelAndView object for each requestHandler method which is present in this 
	 * controller class.
	 * 
	 * 
	 * IMP Point:
	 * -------------
	 * Whenever controller class having a method which is having @ModelAttribute
	 * present on its top then springmVC f/w would  always make a call to that method first
	 * before making call to any of its requestHandler method.
	 * */
	
	
	
}

