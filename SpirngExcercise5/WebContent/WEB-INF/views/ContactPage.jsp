<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ContactPage</title>
</head>
<body>


<h1 style="background-color:DodgerBlue;">ContactPage</h1>
<form action = "${pageContext.request.contextPath}/contact"  method="POST">
           <label for="Name">Name:</label>
           <input type="text" name="userName"></input>
           <br /><br />
           <label for="Message">Message:</label>
           <input type="text" name="message" />
           <br /><br />
           <input type="submit" value="Submit"></input>
       </form>

<p><a href="${pageContext.request.contextPath}/welcome">Welcome</a></p>
</body>
</html>