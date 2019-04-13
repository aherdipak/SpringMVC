<html>
<head>
<title>success</title>
</head>
<body>

	<h1>${ headerMsg}</h1>

	<h1>Congratulations!! the Engineering college has processed your
		Application form successfully</h1>

	<h2>${msg}</h2>

	<h2>Student Submitted Details:</h2>
	<table>
		<tr>
			<td>Student Name:</td>
			<td>${student.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby:</td>
			<td>${student.studenthobby}</td>
		</tr>

		<tr>
			<td>Student Mobile:</td>
			<td>${student.mobileNumber}</td>
		</tr>

		<tr>
			<td>Student DOB:</td>
			<td>${student.dob}</td>
		</tr>

		<tr>
			<td>Student Skills:</td>
			<td>${student.skills}</td>
		</tr>
		
		<tr>
			<td>Student Address:</td>
			<td>country:${student.studentAddress.country}
				city:${student.studentAddress.city}
				street:${student.studentAddress.street}
				pinCode:${student.studentAddress.pinCode}
			</td>
		</tr>
		
	</table>

</body>
</html>