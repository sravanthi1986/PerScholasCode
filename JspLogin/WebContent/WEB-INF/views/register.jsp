<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
	
</head>
<body>
	<h1>Register Form</h1>
	<% if (request.getAttribute("error") != null) {%>
		<p style="color: red;"><%= request.getAttribute("error") %></p>
	<% } %>
	
	
<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
		<label>First Name:&nbsp;<input type="text" name="firstName" /></label><br>
		<label>Last Name:&nbsp;<input type="text" name="lastName" /></label><br>
		<label>Date of Birth:&nbsp;<input type="text" name="dob" /></label><br>
		<label>User Name:&nbsp;<input type="text" name="userName" /></label><br>
		<label>Password:&nbsp;<input type="password" name="userPassword" /></label><br>
		<label>Confirm Password:&nbsp;<input type="password" name="confirmPassword" /></label><br><br>
		<input type="submit" name="Register" value="Register" />
	</form>
</body>
</html>