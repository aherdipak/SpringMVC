<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h3>Student admission form for Engineering</h3>
	
	<!-- TO SHOW ERROR MESSAGES ON FORM -->
	<form:errors path="student.*"/>
	
	
	<form action="./submitAdmissionForm.html" method="post">
		
		<table>
			<tr>
				<td>Student's Name:</td>
				<td><input type="text" name="studentName"/></td>
			</tr>
			<tr>
				<td>Student's Hobby:</td>
				<td><input type="text" name="studentHobby"/></td>
			</tr>
			<tr>
				<td>Student's Mobile:</td>
				<td><input type="text" name="studentMobile"/></td>
			</tr>
			<tr>
				<td>Student's DOB:</td>
				<td><input type="text" name="studentDOB"/></td>
			</tr>
			<tr>
				<td>Student's Skill:</td>
				<td>
					<select name="studentSkill" multiple="multiple">
						<option value="java">java</option>
						<option value="DotNet">dotNet</option>
						<option value="javaScript">javaScript</option>
						<option value="C">C</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Student's Address:</td>
				<td>
					<tr>
						<td>Country:</td>
						<td><input type="text" name="studentAddress.country"/></td>
					</tr>
					<tr>
						<td>city:</td>
						<td><input type="text" name="studentAddress.city"/></td>
					</tr>
					<tr>
						<td>street:</td>
						<td><input type="text" name="studentAddress.street"/></td>
					</tr>
					<tr>
						<td>pincode:</td>
						<td><input type="text" name="studentAddress.pincode"/></td>
					</tr>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit this form"/></td>
			</tr>
		
		</table>
		
	</form>
</body>
</html>
