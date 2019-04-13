
->if user pass alphabets to date field then springMVC fail to process this input.
and it gives 404:The server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing).

--> so how developer deals with such situations ,any dataBinding errors occurse at runtime?
-->SpringMVC have something called as BindingResults & if you place BindingResult on a method argument
	then ,i would catch all binding related errors appropriatly  for you & put all of them into referance of 
	BindingResult.
	> For that you have put following code in jsp file .
	> it will returning back same page to the client.
	
	<form:error path="student.*"/>   -->above form tag
	
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>