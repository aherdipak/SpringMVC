package com.dac.beans;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.dac.custom.validation.IsValidHobby;
import com.dac.custom.validation.IsValidParameterHobby;

public class Student {

	private Address studentAddress;

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	private String studentName;
	
	@Size(min=2,max=30) // with this annotation on top of this field 
	// WE simply convening msg 
	// hey spring mvc framework whenever you performing data binding task
	// for studenthobby field and the value which is bing with it 
	// value having less than 2 and more than 30 then you simply treat that as data binding error and put that into Databiding error ref
	// To activate this annotation you have put @Valid annotation in controller before @ModelAttribute
	
	//@IsValidHobby
	@IsValidParameterHobby(listOfValidHobbies = "Music|Football|Cricket|Hockey")
	private String studenthobby;
	
	
	@Max(2222)
	private Long mobileNumber;
	
	@Past
	private Date dob;
	private List<String> skills;
	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudenthobby() {
		return studenthobby;
	}

	public void setStudenthobby(String studenthobby) {
		this.studenthobby = studenthobby;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	
}
