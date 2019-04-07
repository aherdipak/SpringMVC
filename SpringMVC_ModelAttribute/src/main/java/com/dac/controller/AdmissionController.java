package com.dac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dac.beans.Student;

@Controller
public class AdmissionController {

	@RequestMapping(value="/getAdmissionForm.html",method=RequestMethod.GET)
	public ModelAndView getStudentadmissionForm()
	{
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	/*@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitadmissionForm(@RequestParam("studentName")String name,@RequestParam("studentHobby")String hobby)
	{
		Student student=new Student();
		student.setStudentName(name);
		student.setStudentHobby(hobby);
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("headerMessage", "DAC Engineering college of Engineering,India");
		model.addObject("student", student);
		return model;
	}*/
	
	/*
	 * We can avoid these many RequestParam annotation by using only one @ModelAttribute annotation
	 * to bind all the form element to Student Object.
	 * */
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitadmissionForm(@ModelAttribute("student")Student student)
	{
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("headerMessage", "DAC Engineering college of Engineering,India");
		return model;
	}
	
	/*
	 * Advantage of using @Modelattribute :
	 * 1)No need to write explicit code for creating object Student class.
	 * 2)no need to set value in Student object
	 * 3)no need to bind student object with ModelAndView Object
	 * ----------------------------------------
	 * 
	 * when i use @ModelAttribute annotation on student object then  what's my expectation?
	 * ==> i would want SpringMVC to extract requestParameters & then bind all requestParameter with
	 *    the corresponding properties of student class object.
	 *    
	 *    IMP POint:
	 *    ---------
	 *    The name of field in html page and property of class must be same.
	 *    eg.<input type="text" name="studentName"/>
	 *    
	 *   				 public class Student {
							private String studentName;
							}
	 * 
	 * */
	
	
}
