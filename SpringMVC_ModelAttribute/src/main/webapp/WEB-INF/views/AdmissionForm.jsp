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
	<h3>Student admission form for Engineering</h3>
	<form action="./submitAdmissionForm.html" method="post">
		<p>
			Student's Name:<input type="text" name="studentName"/>
		</p>
		<p>
			Student's Hobby:<input type="text" name="studentHobby"/>
		</p>
		<p>
			<input type="submit" name="submit this form"/>
		</p>
	</form>
</body>
</html>