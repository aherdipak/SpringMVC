<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h3>congratulations..!! the engineering college has processed your application form successfully.</h3>
	<h2>details submitted by you:</h2>
	<table>
		<tr>
			<td>Student Name:</td>
			<td>${student.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby:</td>
			<td>${student.studentHobby}</td>
		</tr>
	</table>
</body>
</html>