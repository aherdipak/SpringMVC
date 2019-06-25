package com.dac.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dac.web.beans.Student;

//@Controller
@RestController
public class RestApiController {

	//************* Retrieving All students records ***************************
	
	 //@ResponseBody  
	 @RequestMapping(value= "/student", method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
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
	// @ResponseBody  
	 @RequestMapping(value= "/student/{name}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public Student getStudent(@PathVariable("name") String studentName) {
		 
		 // fetch the student's record using studentName from the DB
		 Student student = new Student();
		 student.setName(studentName);
		 student.setHobby("WWE");
		 System.out.println(studentName);
		 return student;
	 }
	 
	 //************* Update  student record ****************************
		// @ResponseBody  
	@RequestMapping(value = "/student/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {

		System.out.println("Student Name: " + studentName);
		System.out.println("Student Name: " + student.getName() + "Student Hobby: " + student.getHobby());

		// find the matching student record using "StudentName" from the DB
		// update the matching student record with the information of student sent by
		// the client
		// return true if update is successfully done and return false if update is not
		// done successfully
		
		return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
	}
	 
	@RequestMapping(value = "/student2/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudent2(@PathVariable("name") String studentName, @RequestBody Student student) {

		System.out.println("Student Name: " + studentName);
		System.out.println("Student Name: " + student.getName() + "Student Hobby: " + student.getHobby());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Key1", "Value1");
		headers.add("Key2", "Value2");
		headers.add("Key3", "Value3");	
		
		return new ResponseEntity<Boolean>(false,headers,HttpStatus.OK);
	}
	 
	
}
