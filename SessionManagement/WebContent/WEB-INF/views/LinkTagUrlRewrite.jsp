<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href= "${pageContext.request.contextPath}/LinkTagServlet?value=Good Morning">Link1</a>
<a href="${pageContext.request.contextPath}/LinkTagServlet?value1=Good Evening">Link2</a>
</body>
</html>