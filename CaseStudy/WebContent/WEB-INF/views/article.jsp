<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article</title>
</head>
<body>
<c:choose>
<c:when test="${isAdmin}">
<p style="color:green">${articleSuccess}</p>
<p style="color:red">${articleError}</p>
	<fieldset>
		<legend>Article</legend>
		<form name="categoryCreate" action="${pageContext.request.contextPath}/createArticle"method="POST">
			<label for="categoryName">Article Title:</label> <input type="text"
				name="articleTitle" autofocus></input> <br />
			<br /> <label for="aDescription">Article Content:</label> <input type="text"
				name="articleContent" /> <br />
				<br /> <label for="aCategory">Article Category:</label> 
				<select name="categoryId">
				<c:forEach items="${categoryList}" var="category"> 
				<option value="${category.categoryId}">${category.categoryName}</option>
				</c:forEach>
				
				</select>
				
				
				<br />
				
				
				
			<br /> <input type="submit" value="Submit"></input>
		</form>

	</fieldset>
	</c:when>
	<c:otherwise>
${notAuthorized}
	</c:otherwise>
	
</c:choose>

</body>
</html>