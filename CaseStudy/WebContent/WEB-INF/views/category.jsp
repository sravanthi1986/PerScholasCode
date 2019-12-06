<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<p style="color:green">${categorySuccess}</p>
<p style="color:red">${categoryError}</p>
	<fieldset>
		<legend>Category</legend>
		<form name="categoryCreate" action="${pageContext.request.contextPath}/createCategory"method="POST">
			<label for="categoryName">Category Title:</label> <input type="text"
				name="categoryTitle"></input> <br />
			<br /> <label for="cDescription">Category Description:</label> <input type="text"
				name="categoryDescription" /> <br />
			<br /> <input type="submit" value="Submit"></input>
		</form>

	</fieldset>
</body>
</html>