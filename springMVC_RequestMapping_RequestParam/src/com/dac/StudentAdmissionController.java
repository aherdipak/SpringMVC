package com.dac;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	
	
	@RequestMapping(value="/admissionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm()
	{
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	/*@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName")String name,@RequestParam("studentHobby")String hobby)
	{
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "details submitted by you,Name: "+name+", Hobby: "+hobby);
		
		return model;
	}*/
	
	/*
	 * @RequestParam annotation simply binds the studentName with the name variable &
	 * value of studentHobby with the hobby variable & farther you can use those values 
	 * anywhere in the method
	 * */
	
	/*
	 * What if client doesn't provide value of studentName to my application it simply returns empty string.
	 * 
	 * QUESTION : 
	 * 
	 * Now what in this case ,i want to give some default value to the studentName when client doesn't provide any value?
	 * 
	 * */
	
	/*@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName",defaultValue="Mr.ABC")String name,@RequestParam("studentHobby")String hobby)
	{
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "details submitted by you,Name: "+name+", Hobby: "+hobby);
		
		return model;
	}*/
	
	/*
	 * we can avoid these many RequestParam annotations
	 *  by using only one RequestParam annotation on a Map as like PathVariable annotation
	 * */
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> reqPar)
	{
		String name=reqPar.get("studentName");
		String hobby=reqPar.get("studentHobby");
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "details submitted by you,Name: "+name+", Hobby: "+hobby);
		
		return model;
	}
	
}
