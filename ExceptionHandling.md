## Exception Handling 01

use : SpringMVC_ExceptionHandling

In general what happens when your springMVC application throws some ```xyz``` Exception without any code to handle that.

Let's check it out.

When a user request for this url ```http://localhost:8081/SpringMVC_ExceptionHandling/getStudentAdmissionFormPage.htm```

The belove method in AdmissionController class gets executed and webpage sends to the user As a response.

```
@RequestMapping(value="/getStudentAdmissionFormPage.htm", method=RequestMethod.GET)
public ModelAndView getStudentAdmissionFormPage() {
	ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
	modelAndView.addObject("headerMsg", "Enginnering College,India");
	return modelAndView;
}
```
And if everything goes fine on server while processing this request user will get `studentAdmissionForm` webpage as a response.

Now, due to some developer mistake or some other reason if while processing the request, request handling method throws some exception, say NullPointerException, ResourceNotFoudound or any other. what's gonna happen What user wanna gets In that case as a response.

As example: 

Bellow method throws NullPointerException for above request.

```
	@RequestMapping(value="/getStudentAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage() {
		
		String exceptionOccured = "NULL_POINTER";
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null Pointer Exception");
		}
		
		ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
	 
```

Imp point to notice No ware in this code I am handling NullPointerException.

Now I would request for admission form.
What's gonna happen, what I would get as a response?
It has sent bellow error page

![image](https://user-images.githubusercontent.com/35020560/57191396-b82d1e00-6f42-11e9-8c35-76181911bdd0.png)


On this page its talking about two imp points.
On top it has mention HTTP Status code 500,Then the brief description of the error which occurred on the server.

Normally when any exception occurs for which there is no exception handling code return in the controller class Then the application by default sends an error page like above image.

Now many times developers would like to send customized error web page Instead of this default error page which doesn't seem so much user friendly.

### Question 1: 

#### So the question is what task I need to perform in this application so that I would be able to send customized Error webpage when this method would throw null pointer exception while processing the request?

Guy's to tackle with this requirement I just need to perform these two simple steps And I will be done.


```markdown
1. Include a JSP page NullPointerException.jsp
2. Include a method with @ExceptionHandler annotation on its top as shown below:

@ExceptionHandler(value = NullPointerException.class)
public String handleNullPointerException(Exception e){

// logging Null Pointer Exception
System.out.println("Null Pointer Exception Occured: "+e);

return "NullPointerException";


}

```


### Question 1: 
#### Whatever value provided in a student hobby field that values minimum length of 2 chars and never exceeds 30 chars and if the user violates this rule at a time of submitting the form then my spring application return the same form back to the client with a complete description of the violated rule, How to achieve such things?

##### \Student.java
```
public class Student {

	private String studentName;
	
	@Size(min=2,max=30) // with this annotation on top of this field 
	// WE simply conveying message 
	// hey spring mvc framework whenever you performing data bainding task
	// for studenthobby field and the value which is being with it 
	// value having less than 2 and more than 30 then you simply treet that as data binding error and put that into Databiding eror ref
	// To activate this annotation you have put @Valid annotation in controller before @ModelAttribute
	private String studenthobby;
	
	private Long mobileNumber;
	private Date dob;
	private List<String> skills;
	
	private Address studentAddress;
	
	// getter & setter
}
```
##### \FormValidationController.java
```
@Controller
public class FormValidationController {
	
	
	@RequestMapping(value="/getStudentAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage() {
		ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
	
	// if we dont put @Valid thenspring mvc completely ignore form validation anotations kept in student class
	@RequestMapping(value="/submitStudentAdmissionForm.htm", method=RequestMethod.POST)
	public ModelAndView submitStudentAdmissionForm(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
			return modelAndView;
		}
		
		ModelAndView modelAndView = new ModelAndView("admissionSuccessNew");
		
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		modelAndView.addObject("msg", "Form Submitted by Name: "+ student.getStudentName() +" Hobby: "+student.getStudenthobby());
		
		return modelAndView;
	}

}

```
##### @Valid 
With this annotation, we simply instructing spring MVC framework hey spring MVC framework whenever you performing data binding task for this student obj. it's only that time you consider all those form validation related annotation which are kept in student class So the idea is very clear if we put @Valid here then and only then spring MVC framework will consider form validation annotations.
