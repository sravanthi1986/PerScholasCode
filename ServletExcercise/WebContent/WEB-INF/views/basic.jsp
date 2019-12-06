<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Java Servlet Page Intro</h1>
	<% String s = "John"; %>
	<h2>Welcome <% out.print( s ); %></h2>

</body>
</html>