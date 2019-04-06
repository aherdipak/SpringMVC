package com.dac.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class pathVariableController {
	
	@RequestMapping("/welcome1/countryName/userName")
	public ModelAndView helloWorld()
	{
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg", "Hey world");
		return model;
	}
	
	/*
	 * i want to call same method using bellow url then how to call
	 * 
	 * http://localhost:8080/Spring_PathVariable/welcome/countryName/Deepak
	 * */

	@RequestMapping("/welcome2/countryName/{userName}")
	public ModelAndView helloWorld2()
	{
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg", "Hey world");
		return model;
	}
	
	/*
	 * what if in this method i would want to retrieve the 
	 * value of userName which is coming in the incoming request URL?
	 * */
	@RequestMapping("/welcome3/countryName/{userName}")
	public ModelAndView helloWorld3(@PathVariable("userName")String name)
	{
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg", "Hey world "+name);
		return model;
	}
	
	/*
	 * @PathVariable annotation would bind 
	 * the value of userName in which is coming in incoming request with the name variable.
	 * */
	@RequestMapping("/welcome4/{countryName}/{userName}")
	public ModelAndView helloWorld4(@PathVariable("countryName")String country,@PathVariable("userName")String name)
	{
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg", "Hey user,Hello: "+name+" you are from: "+country);
		return model;
	}
	/*
	 * SpringMVC says hey developer you no need to put this much efforts to bind pathVariable 
	 * if i give such a facility where in less code you can do same task in simple way
	 * */
	@RequestMapping("/welcome5/{countryName}/{userName}")
	public ModelAndView helloWorld5(@PathVariable Map<String,String> pathVars)
	{
		String name=pathVars.get("userName");//userName is key in Map
		String country=pathVars.get("countryName");
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg", "Hey user,Hello: "+name+" you are from: "+country);
		return model;
	}
	/*
	 * IMP points:
	 * When you use @PathVariable with Map
	 * then you have to place following line in spring config file i.e. springmvc.servlet.xml
	 * <mvc:annotation-driven></mvc:annotation-driven>
	 * */
}

