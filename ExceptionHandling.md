## Exception Handling 01

Refer Example : SpringMVC_ExceptionHandling

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

Now, due to some developer mistake or some other reason if while processing the request, request handling method throws some exception, say NullPointerException, ResourceNotFoudound or any other. what's gonna happen? What user wanna gets In that case as a response?

As example: 

Bellow method throws NullPointerException for above URL request.

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

Important point to notice No here in this code I am not handling NullPointerException.

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

When user request to the Admission Form page this request handling method throw NullPointerException and And immediately after that springmvc framework started looking for a method In the same controller class which has an `@ExceptionHandler` annotation on top of it and value as `NullPointerException.class`

##### /NullPointerException.jsp

```
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>success</title>
</head>
<body>

	<h1>${headerMsg}</h1>
	<h1>STUDENT ADMISSION FORM FOR ENGINEERING COURSE</h1>
	
	<p>The application has encountered a Null Pointer error. Please contact support by sending an email at webmaster@dac.com</p>

</body>
</html>

```


Some important point to notice:

This controller class we are handling only NullPointerException So if request handling method throws any other exception at runtime while processing The request like IoException, ArthmeticException means exception for which We have not put any exception handler method the application gonna send the default Error webpage to the user as a response as we sow in a NullPointerException

```
@ExceptionHandler(value = IOException.class)
public String handleIoException(Exception e){
	System.out.println("IO Exception Occured: "+e);
	return "IOException";
}

```

##### /IOException.jsp

```
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>success</title>
</head>
<body>

	<h1>${headerMsg}</h1>
	<h1>STUDENT ADMISSION FORM FOR ENGINEERING COURSE</h1>
	
	<p>The application has encountered a Input Output error. Please contact support by sending an email at webmaster@dac.com</p>

</body>
</html>
```

Now the important point to not here is your controller class might throw a lot off Exceptions at runtime and it may not convenient so to write exception handler method For each exception.

### Question 2:
#### So to tackle such a problem what we do, we can add a generic exception handling method In this controller class, such that when this controller class throws some exception for which Speingmvc doesn't find related exception handler method, then it would go and search for Generic exception handler method And if it finds then it would simply go and execute that. So the question is how we would add such method in the controller class?

```
@ExceptionHandler(value = Exception.class)
public String handleException(Exception e){
	System.out.println("IO unknown Occured: "+e);
	return "Exception";

}
```
##### /Exception.jsp

```
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>success</title>
</head>
<body>

	<h1>${headerMsg}</h1>
	<h1>STUDENT ADMISSION FORM FOR ENGINEERING COURSE</h1>
	
	<p>The application has encountered a unknown error. Please contact support by sending an email at webmaster@dac.com</p>

</body>
</html>
```

