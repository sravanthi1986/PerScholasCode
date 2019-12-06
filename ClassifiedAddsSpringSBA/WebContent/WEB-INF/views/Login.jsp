<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Login</legend>
		<form action="${pageContext.request.contextPath}/"method="POST">
			<label for="userName">UserName:</label> <input type="text"
				name="userName"></input> <br />
			<br /> <label for="password">Password:</label> <input type="password"
				name="password" /> <br />
			<br /> <input type="submit" value="Login"></input>
		</form>
		<p>
			<a href="${pageContext.request.contextPath}/register">Register</a>
			<br>
			<a href="${pageContext.request.contextPath}/showAdds">Back to classifieAdds</a>
		</p>
	</fieldset>
</body>
</html>