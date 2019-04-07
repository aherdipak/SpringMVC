package com.dac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dac.beans.Student;

@Controller
public class StudentadmissionController {

	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getadmissionForm() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student")Student student,BindingResult result)
	{
		if(result.hasErrors())
		{
			ModelAndView model=new ModelAndView("AdmissionForm");
			return model;
		}
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		return model;
	}
	@ModelAttribute
	public void addingCommandObjects(Model model)
	{
		model.addAttribute("headerMessage", "DAC College of Engineering,India");
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyy***MM***dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		
		 * SpringMVC internally uses a concept called PropertyEditor in order to perform data binding task.
		 * 
		 * What exactly i mean sprinMVC has many build in classes called as propertyEditor classes CustomDateEditor
		 * is one of them.
		 * 
		 * >SpringMVC uses PropertyEditor classes in order to perform type conversion while performing DataBinding.
		 * 
		
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}*/

}
