<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">

<div>
			<label>Name: </label>
			<input type="text" name="name" />
		</div>
		<div>
			<label>Password: </label>
			<input type="text" name="password" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>
</body>
</html>