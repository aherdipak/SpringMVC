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

#### /Student.java
```
@Size(min=2,max=30) 
private String studenthobby;
	
```

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
 
 5.if above key also not found,then Spring mvc would use the default error message for that
  constraint violation 
  e.g In this case,must be between 2 and 30 (default error message for Size constraint)
 
```
### Question 3: 
#####  In the future, some developer makes a change in belove min, max and `studenthobby` name then he must do changes in the properties file.

#### /Student.java
```
@Size(min=5,max=15) 
private String studenthobby;

```
##### To make dynamic error message in properties file we have to make changes as belove.
#### /studentmessage.properties
```
Size.student.studenthobby = Please enter a value for {0} filed between {3} and {2} charector

```
Spring MVC will replace all these placeholders with the corresponding values which we have provided in the bean class.

#### SOME IMPORTANT POINT'S TO NOTE HERE:
```markdown

1. placeholder {0} is always replace dynamically by Spring mvc with the name of field for which violation occurs.
   e.g in this demo. violation occured for studenthobby filed, So {0} was replaced with "studenthobby"

2. placeholder {1},{2},{3},{4} and so on.... would be replaced with the arguments values passed to the
   constraint annotation.
   e.g in this demo, we passed two argument to @size annotation i.e min=3 and max=30, So placeholder{1} and {2}
   were replaced with these argument values

3. Why in this demo, placeholder{1} was replaced with the max argument value i.e 30 and not with the min argument i.e 2 
  (In the similar ways, why {2} was replaced with the min value and not with max value) ?

ANS: Its because Spring mvc uses alphabetical order of argument to decide upon which placeholder to 
  be replaced with which argument values, in this demo , if we observe alphabetically - max comes before min argument 
  so {1} was replaced with the max value and {2} was replaced with the min value.
  
```
#### One Last Concept :
After changes in properties file every time we have to restart the server to load the properties file to avoid this add following configuration change in spring-servlet.xml file

```

<bean id="messageSource"
		class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
			<property name="basename" value="/WEB-INF/studentmessage"></property>
			<property name="cacheSeconds" value="1" />
	</bean>
```
Spring MVC will load all changes done in this file will load after every one Second.
This feature may degrade the performance of an application that's why not recommended in production areas, used in the only developer environment.

## Form Validations 03 (@Pattern, @Past, @Max and some more...)

### Question 1: 
#### Degit not allowed in `studentName`?

#### /Student.java
```
@Pattern(regexp="[^0-9]*")
private String studentName;

```

### Question 2: 
#### Student date of birth`(dob)` is not fall in feture i.e Feture date not allowed in dob field?
With @Past annoation, we simply instructing spring mvc framework whenever you are performing data binding task for dob property and the value which you are binding with it falling in future that time simply treat as a binding error.

#### /Student.java
```
@Past
private Date dob;
    
```

### Question 2: 
#### `<= 2222` value in mobile number field? if user give 2224 then my appliaction return back form with error msg.

#### /Student.java
```
 @Max(2222)
 private Long mobileNumber;
	
```
 #### IN SIILAR MANNER
    @Future : checks whether the annoation date is in the future 
    @Min : check that the annoation value is higher than or equals the specified minimum.
    @NotNull : check that the annoation value is not null.
    @NotEmpty : chekc if the string is not null nor empty(is not supported by bean validation specification ... its only available to devepers if they are using hibernate validation lib in thier spring appliaction) 
