<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "${pageContext.request.contextPath}/registerUser"  method="POST">
           <label>First Name:</label>
           <input type="text" name="firstName"></input>
           <br /><br />
           <label >Last Name:</label>
           <input type="text" name="lastName" />
           <br /><br />
           <label >Email:</label>
           <input type="text" name="email" />
           <br /><br />
           <label >Password:</label>
           <input type="text" name="password" />
           <br /><br />
           <label >ConfirmPassword:</label>
           <input type="text" name="confirmpassword" />
           <br /><br />
           <label >DOB:</label>
           <input type="text" name="dob" />
           <br /><br />
           <input type="submit" value="Submit"></input>
</body>
</html>