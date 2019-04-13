### Requirement:

If user pass alphabets to date field then springMVC fail to process this input.
and it gives 404:The server cannot or will not process the request due to something that is perceived to be a client error.

(e.g. malformed request syntax, invalid request message framing, or deceptive request routing).

##### So how developer deals with such situations,any DataBinding errors occurse at runtime?

SpringMVC have something called as BindingResults & if you place BindingResult on a method argument then,I would catch all binding related errors appropriatly for you & put all of them into referance of BindingResult.

--> For that you have put following code in jsp & java file.

#### \StudentadmissionController.java
```
@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student")Student student,BindingResult result){
		// IF ERROR, THEN IT WILL RETURN SAME PAGE BACK WITH ERROR MESSAGES
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("AdmissionForm");
			return model;
		}
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		return model;
	}
```


#### \AdmissionForm.jsp
 ``` 
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- ON TOP OF THE PAGE -->
 <form:error path="student.*"/>   <!-- Above form tag -->
 ```
