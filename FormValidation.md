## Form Validations 01 ( using JSR 303/349 provided annotations ) 

### Question 1: 
#### Whatever value provided in student hobby field that values minimum length of 2 char and never exceeds 30 char and user violates this rule at a time of submitting the form then my spring application return same form back to the client with complete description of the violated rule, How to achieve such things?

we are using hibernate-validator in this example.

### /pom.xml

Update pom.xml file with `hibernate-validator`jars

```
 <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-validator -->
	<dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-validator</artifactId>
	    <version>6.0.13.Final</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
	<dependency>
	    <groupId>javax.validation</groupId>
	    <artifactId>validation-api</artifactId>
	    <version>2.0.1.Final</version>
	</dependency>
```
### /FormValidationController.java

```
@RequestMapping(value="/submitStudentAdmissionForm.htm", method=RequestMethod.POST)
		public ModelAndView submitStudentAdmissionForm(@Valid @ModelAttribute("student") Student student, BindingResult result) {
			
			//TO CHECK ERROR IS PRESENT, IF PRESENT THEN SIMPLY RETURN SAME FORM WITH ERROR DESCRIPTION BACK TO USER
			if(result.hasErrors()) {
				ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
				return modelAndView;
			}
			
			ModelAndView modelAndView = new ModelAndView("admissionSuccessNew");
			
			modelAndView.addObject("headerMsg", "Enginnering College,India");
			modelAndView.addObject("msg", "Form Submitted by Name: "+ student.getStudentName() +" Hobby: "+student.getStudenthobby());
			
			return modelAndView;
		}
    
```

### @Valid
 
With this annotation, we simply instructing spring MVC framework hey spring MVC framework whenever you performing data binding task for this student object. It's only that time you consider all those form validation related annotation which are kept in student class like( @Size,@NotEmpty,@Email, etc. )
So the idea is very clear if we put @Valid in request handling method parameter ( before @ModelAttribute )  then and only then spring MVC framework will consider form validation annotations. If we don't put @Valid then spring MVC completely ignore form validation annotations kept in student class.

### /studentAdmissionForm.jsp

Update jsp page with following lines of code to show error messages return by spring application on user screen.

```
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- On top of the page -->
 <form:errors path="student.*"/> . <!-- Just before starting form Tag -->
 
```

## Form Validation 02 (customizing error messages using Spring MessageSource)

### Question 1: 
#### If user voilates form validation rule sprin MVC return from the back with default error messages, it's not so user-friendly. What if we want to display error msg more user-friendly like: "Please enter a value for student hobby filed between 2 and 30 characters".
#### how would you do it?

### /Student.java
```
@Size(min=2,max=30,message="Please enter a value for studenthobby filed between 2 and 30 charector") 
 private String studenthobby;
```
In the above case value 2 and 30 in errormsg are hardcoded to make them dynamic.
```
@Size(min=2,max=30,message="Please enter a value for studenthobby filed between {min} and {max} charector")

```

### Question 2: 
#### Now my requirement is I don't want to keep my error messages in class. I want to keep all error messages in the separate properties file?

#### /spring-servlet.xml

```
<bean id="messageSource"
		class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
			<property name="basename" value="/WEB-INF/studentmessage"></property>
	</bean>
	
```

#### /studentmessage.properties

```
Size.student.studenthobby = Please enter a value for studenthobby filed between 2 and 30 charector

```
##### Some important point's

```markdown
 1. Spring mvc search for a key matching with this key pattern -
 [Validation Annotation Name].[Object Reference Name].[Field Name]
 e.g In this case,Size.student.studenthobby

 2. If above key pattern not found,then Spring MVC would again search for a key matching with this key
 [Validation Annaotation Name].[Field Name]
 e.g In this case,Size.studenthobby

 3. If above key pattern not found, then Spring mvc would again search for a key matching with this key
 [Validation Annaotation Name].[Field Type]
 e.g In this case,Size.java.lang.String
 
 4. if above kay pattern not found , then Spring mvc would finally search for a key matching with this key
 [Validation Annaotation Name]
 e.g In this case,Size
 
  5. if above key also not found,then Spring mvc would use the default error message for that
 constraint violation 
 e.g In this case,must be between 2 and 30 (default error message for Size constraint)
 
```
