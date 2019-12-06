<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>servletexcercise1</h1>
<form action = "HomeServlet"  method="POST">
           <label for="userName">UserName:</label>
           <input type="text" name="userName"></input>
           <br /><br />
           <label for="password">Password:</label>
           <input type="text" name="password" />
           <br /><br />
           <input type="submit" value="Submit"></input>
       </form>
</body>
</html>