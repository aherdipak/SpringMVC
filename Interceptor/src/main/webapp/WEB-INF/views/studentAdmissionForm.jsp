<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>success</title>
</head>
<body>
<!-- if i click on this link this webpage again request for it self and along with that request it sends parameter name siteLanguage to the server-->
<a href="/FirstMVC/getStudentAdmissionFormPage.htm?siteLanguage=en">English</a> |
<a href="/FirstMVC/getStudentAdmissionFormPage.htm?siteLanguage=fr">French</a>

	<h1>${headerMsg}</h1>
	<h1>STUDENT ADMISSION FORMFOR ENGINEERING COURSE</h1>

<form:errors path="student.*"/>

	<form action="./submitStudentAdmissionForm.htm" method="post">

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