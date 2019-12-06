<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<p style="color: red;">${errorMessage}</p>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/loginMember" method="post">
		<div>
			<label>Name: </label>
			<input name="name" />
		</div>
		<div>
			<label>Password: </label>
			<input name="password" />
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/HomeInsuranceServlet/register">Register</a> <input type="submit" value="Login" /> 
		</div>
	</form>
</body>
</html>