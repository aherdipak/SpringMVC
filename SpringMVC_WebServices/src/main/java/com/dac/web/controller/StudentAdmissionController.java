package com.dac.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dac.web.beans.Student;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value = "/getAdmissionForm.html", method = RequestMethod.GET)
	public ModelAndView getStudentadmissionForm() {
		ModelAndView model = new ModelAndView("admissionForm");
		return model;
	}
	
	/************* Retrieving All students records ****************************/
	
	 @ResponseBody // to convert java object to JSON String 
	 @RequestMapping(value= "/student", method=RequestMethod.GET)
	 public List<Student> getStudentList(){

	   Student std1 = new Student("Mahatma gandhi");
	   Student std2 = new Student("Vivek");
	   Student std3 = new Student("Narendra"); 
	   Student std4 = new Student("Amit"); 

	   List<Student> list = new ArrayList();
	   list.add(std1);
	   list.add(std2);
	   list.add(std3);
	   list.add(std4);
	   return list;
	 }
	 
	 //************* Retrieving  student record ****************************
	 @ResponseBody  
	 @RequestMapping(value= "/student/{name}", method=RequestMethod.GET)
	 public Student getStudent(@PathVariable("name") String studentName) {
		 
		 // fetch the student's record using studentName from the DB
		 Student student = new Student();
		 student.setName(studentName);
		 student.setHobby("WWE");
		 System.out.println(studentName);
		 return student;
	 }
	 
	 
}
