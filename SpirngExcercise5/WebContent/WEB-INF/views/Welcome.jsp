<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>Thank you ${currentUser} we will reach you shortly</h1>
<p><a href="${pageContext.request.contextPath}/aboutme">About Me</a></p>
<br>
<p><a href="${pageContext.request.contextPath}/contactme">Contact Me</a></p>

</body>
</html>