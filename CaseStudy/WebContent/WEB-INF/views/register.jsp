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
			<label>First Name:</label> <br>
			<input type="text" name="firstName" autofocus required></input><br>
			<label>Last Name:</label> <br>
			<input type="text" name="lastName" required/> <br>
			<label>Email:</label><br>
			<input type="text" name="email" required/>  <br>
			<label>User name:</label><br>
			<input type="text" name="userName" required/>  <br>
			<label>Password:</label><br>
			<input type="password" name="password" required /> <br>
			<label>ConfirmPassword:</label><br>
			<input type="password" name="confirmpassword" required /> <br>
			<label>DOB:</label><br>
			<input type="text" name="dob"  /> <br> 
			<label>Contact Number:</label><br> 
		    <input type="number" name="contactNo" required /> <br> <br> 
			<input type="submit"value="Register"></input>
				
		</form>
	</fieldset>
</body>
</html>