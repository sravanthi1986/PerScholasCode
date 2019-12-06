<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> expression for language</h1>
 <h2>favouite cookie:${cookie.myFavoriteCookie.value} </h2>
 
 <a href="${pageContext.request.contextPath}/CookiesServlet">CLICKHERE togo cookiespage </a>
</body>
</html>