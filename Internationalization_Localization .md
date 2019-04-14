## Internationalization and Localization 01

Internationalization - The process of creating or developing a web application in such a generic manner that which can handle or support more than one language is known as Internationalization.

### Question 1: 

#### What if 50% of visitors of this demo application want ot view this webpage in English and the remaining 50% in french, So how to make this application support multiple languages?

##### /admissionForm.jsp

```
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>success</title>
</head>
<body>
	<h1>${headerMsg}</h1>
	<h1>STUDENT ADMISSION FORMFOR ENGINEERING COURSE</h1>

<form:errors path="student.*"/>

	<form action="/FirstMVC/submitStudentAdmissionForm.htm" method="post">

		<table>
			<tr>
				<td><spring:message code="label.studentName"/></td>
				<td><input type="text" name="studentName"></td>
			</tr>
			<tr>
				<td><spring:message code="label.studenthobby"/></td>
				<td><input type="text" name="studenthobby"></td>
			</tr>
			
			<tr>
				<td><spring:message code="label.mobileNumber"/></td>
				<td><input type="text" name="mobileNumber"></td>
			</tr>
			
			<tr>
				<td><spring:message code="label.dob"/></td>
				<td><input type="text" name="dob"></td>
			</tr>
			
			<tr>
				<td><spring:message code="label.skills"/></td>
				<td><select name="skills" multiple>
					<option value="core java">core java</option>
					<option value="Spring">Spring</option>
					<option value="hibernate">hibernate</option>
					</select></td>
			</tr>
			
		</table>
		
		<h3><spring:message code="label.address"/></h3>
		<!-- SPRING MVC WILL AUTOMATICALLY BIND  THIS studentAddress.country FORM ELEMENTS VALUE WITH COUNTRY PROPERTY OF studentAddress PROPERTY -->
		<!-- LIKE THIS SPRING MVC WILLBIND THESE OTHER ALL FORM PEOPERTY ELEMENTS WITHITS CORRESPONDINNG  PROPERTY OF studentAddress PROPERTY  -->
		<table>
			<tr>
				<td><spring:message code="label.country"/></td>
				<td><input type="text" name="studentAddress.country"></td>
			</tr>
			<tr>
				<td><spring:message code="label.city"/></td>
				<td><input type="text" name="studentAddress.city"></td>
			</tr>
			
			<tr>
				<td> <spring:message code="label.street"/></td>
				<td><input type="text" name="studentAddress.street"></td>
			</tr>
			
			<tr>
				<td><spring:message code="label.pinCode"/></td>
				<td><input type="text" name="studentAddress.pinCode"></td>
			</tr>	
		</table>
		<input type="submit" value="Click !!!">
	</form>
</body>
</html>

```


##### /studentmessage_en.properties

```

Size.student.studenthobby = Please enter a value for {0} filed between {2} and {1} charector
label.studentName  = Student Name:
label.studenthobby = Student Hobby:
label.mobileNumber = Student Mobile:
label.dob = Student DOB:
label.skills = Student Skills:
label.address = Student Address
label.country = Student country:
label.city = Student city:
label.street = street:
label.pinCode = Student pinCode:

```


##### /studentmessage_fr.properties

```
Size.student.studenthobby = Veuillez saisir une valeur pour {0} classé entre {2} et {1}.
label.studentName  = Nom d'étudiant:
label.studenthobby = Passe-temps étudiant:
label.mobileNumber = Mobile étudiant:
label.dob = Étudiant DOB:
label.skills = Compétences des étudiants:
label.address = Adresse de l'étudiant
label.country = Pays étudiant:
label.city = Ville étudiante:
label.street = rue:
label.pinCode = Code PIN étudiant:

```

##### /StudentAdmissionController.java

```
@RequestMapping(value="/getAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage() {
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
```

Every browser has a language preference setting feature provided in it e.g chrome 

Setting --> languages and input settings --> here if the user has provided frensh as a preferred language over English,
then the content of the webpage will be shown in French.
If he has provided English then the content of the webpage in the English language.

#### form in French language

![image](https://user-images.githubusercontent.com/35020560/56094795-088cff00-5ef4-11e9-9454-fa2439759e22.png)

