<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<link href="<spring:url value="/resources/css/main2.css" />"
	rel="stylesheet" />
<style>
.register label{margin-bottom:2px;margin-top:5px}
.register input{padding:4px}
.form{width:45%}
</style>
</head>
<body class="is-preload no-sidebar">
	<div id="page-wrapper">
	<%@include file="header.jsp"%>

	<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						<div id="content">

		<p style="font-weight:bold">${userUpdateSuccess}</p> 
		<div class="form">
		<form class="register" action="${pageContext.request.contextPath}/updateUser"
			method="POST">
			<label>First Name:</label>
			<input type="text" name="firstName" value="${userDetails.firstName}" autofocus required></input>
			<label>Last Name:</label> 
			<input type="text" name="lastName" value="${userDetails.lastName}" required/> 
			<label>Email:</label>
			<input type="text" name="emailId" value="${userDetails.emailId}" required/>  
			<label>DOB:</label>
			<input type="text" name="dob"  />  
			<label>Contact Number:</label> 
		    <input type="number" name="contactNo" value="${userDetails.contactNo}" required />  <br><br>
			<input type="submit"value="Update"></input>
				
		</form>
</div>
	</div>
	</div>
	</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>