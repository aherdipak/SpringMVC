
## @ModelAttribute in SpringMVC


### \HomeController.java
```

	
	@RequestMapping(value="/getAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getAdmissionFormPage() {
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		//modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
	
	
	/*@RequestMapping(value="/submitAdmissionForm.htm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String studentName ,@RequestParam("studenthobby") String studenthobby) {
		ModelAndView modelAndView = new ModelAndView("admissionSuccessNew");
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudenthobby(studenthobby);
		
		modelAndView.addObject("headerMsg", "Engnnering College,India");
		
		modelAndView.addObject("msg", "Form Submitted by Name: "+ studentName +" Hobby: "+studenthobby);
		
		modelAndView.addObject("student", student);
		
		return modelAndView;
	}*/
	
	
	
	@RequestMapping(value="/submitAdmissionForm.htm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student") Student student) {
		ModelAndView modelAndView = new ModelAndView("admissionSuccessNew");
		
		//modelAndView.addObject("headerMsg", "Enginnering College,India");
		modelAndView.addObject("msg", "Form Submitted by Name: "+ student.getStudentName() +" Hobby: "+student.getStudenthobby());
		
		return modelAndView;
	}
	
	
	// ------  @ModelAttribute at method lavel ----------------
	// Remove above methods headerMsg message from ModelAndView object
	// by using @ModelAttribute at method lavel we can give comman message 
	// by wrinting less code we  can achieve this
	// you can add any number colllection object here
	// IF A CONTROLLER CLASS HAVING METHOD MODELATTRIBUTE PRESENT ON ITS TOP THEN SPRING MVC FRAMEWORK WOULD ALWAYS CALL TO THAT METHOD FIRST BEFORE MAKING CALL TO ANY OF ITS REQUEST HANDLER METHODS 
	@ModelAttribute
	public void addingCommanHeader(Model model) {
		model.addAttribute("headerMsg", "Enginnering College, India");
	}
	
```
### studentAdmissionForm.jsp

```
<html>
<head>
<title>success</title>
</head>
<body>
<h1>${headerMsg}</h1>
<h1> STUDENT ADMISSION FORMFOR ENGINEERING COURSE</h1>

<form action="/FirstMVC/submitAdmissionForm.htm" method="post">
<p>
	Student Name : <input type="text" name="studentName">
</p>

<p>
	Student Hobby : <input type="text" name="studenthobby">
</p>
<input type="submit" value="Click !!!">
</form>

<h2>${msg}</h2>
</body>
</html>

```

### studentSuccessForm.jsp

```

<html>
<head>
<title>success</title>
</head>
<body>

<h1>${ headerMsg}</h1>

<h1>Congratulations!! the Engineering college has processed your Application form successfully </h1>

<h2>${msg}</h2>

<h2>Student Submitted Details:</h2>
<table>
<tr>
	<td>Student Name:</td>
	<td>${student.studentName}</td>
</tr>
<tr>
	<td>Student Hobby:</td>
	<td>${student.studenthobby}</td>
</tr>
</table>

</body>
</html>

```



