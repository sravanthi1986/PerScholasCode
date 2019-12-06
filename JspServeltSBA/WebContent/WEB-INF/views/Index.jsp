<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Welcome QE studnets....<% out.println(new Date()); %></p>
<h3>second way to dispaly date </h3>
Today's date: <%= (new java.util.Date()).toLocaleString()%>

</body>
</html>