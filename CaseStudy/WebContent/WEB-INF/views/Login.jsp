<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Raising Kids:Login</title>
</head>
<body background="/CaseStudy/resources/images/baby-feet.jpg" width="20%" height="20%">
	<fieldset>
		<legend>Login Form</legend>
		<form:form action="${pageContext.request.contextPath}/loginUser" method="post" modelAttribute="user">
			<div>
				<label for="userName">User Name</label>
				<div>
					<form:input path="userName"/>
					<p style="color:red;"><form:errors path="userName" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="userPassword">Password</label>
				<div>
					<form:input type="password" path="userPassword"/>
					<p style="color:red;"><form:errors path="userPassword" class="error"/></p>
				</div>
			</div>
			<input type="submit" value="Login" />
			<a href="${pageContext.request.contextPath}/register">Register</a>
		</form:form>
	</fieldset>
	
</body>
</html>