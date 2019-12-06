<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
.register label{margin-bottom:2px;margin-top:5px}
.register input{padding:4px}
</style>
</head>
<body>
	<fieldset>
		<legend>Register</legend>
		<form class="register" action="${pageContext.request.contextPath}/registerUser"
			method="POST">
			
			<label for="userName">UserName:</label> <input type="text"
				name="userName"></input> <br />
			<br /> <label for="password">Password:</label> <input type="password"
				name="password" /> <br />
			<br /> <input type="submit" value="Register"></input>
		</form>
		<p>
			<a href="${pageContext.request.contextPath}/">Back to Login</a>
			
		</p>		
		</form>
	</fieldset>
</body>
</html>