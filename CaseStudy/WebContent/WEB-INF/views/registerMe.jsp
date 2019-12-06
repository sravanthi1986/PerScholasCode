<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
<fieldset>
		<legend>Register</legend>
		<form:form action="${pageContext.request.contextPath}/registerUser" method="post" modelAttribute="userdetails">
			<div>
				<label for="firstName">FirstName:</label>
				<div>
					<form:input path="firstName"/>
					<p style="color:red;"><form:errors path="firstName" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="lastName">LastName: </label>
				<div>
					<form:input path="lastName"/>
					<p style="color:red;"><form:errors path="lastName" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="username">userName: </label>
				<div>
					<input name="userName" type="text"/>
					<p style="color:red;"></p>
				</div>
			<div>
			<div>
				<label for="password">Password: </label>
				<div>
					<input name="password" type="password"/>
					<p style="color:red;"></p>
				</div>
			<div>
			
				<label for="emailId">emailId: </label>
				<div>
					<form:input path="emailId"/>
					<p style="color:red;"><form:errors path="emailId" class="error"/></p>
				</div>
				<div>
				<label for="contactNo">ContactNo: </label>
				<div>
					<form:input path="contactNo"/>
					<p style="color:red;"><form:errors path="contactNo" class="error"/></p>
				</div>
				
			<input type="submit" value="Register" />
		</form:form>
	</fieldset>

</body>
</html>