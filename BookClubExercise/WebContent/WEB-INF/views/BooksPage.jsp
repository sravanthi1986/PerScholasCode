<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Page</title>
</head>
<body>
	<h1>Books Page</h1>
	<%@ include file="Navigation.html" %>
	<form action = "${pageContext.request.contextPath}/HomeServlet/createBook">
		<div>
			<label>Book Title:</label>
			<input name="title" />
		</div>
		<div>
			<label>Book Synopsis</label>
			<input name="synopsis" />
		</div>
		<div>
			<label>Book Author:</label>
			<input name="author" />
		</div>
		<div>
			<label>Date &amp; Time:</label>
			<input type="datetime-local" name="dateTime" />
		</div>
		<div>
			<input type="submit" value="Create Book" />
		</div>
	</form>
	
	<table>
		<tr>
			<th>Title</th>
			<th>synopsis</th>
			<th>Author</th>
			<th>Date and Time</th>
		</tr>
		<c:forEach items="${allBooks}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.synopsis}</td>
				<td>${book.author}</td>
				<td>${book.dateTime}</td>
				<td>
					<c:choose>
						<c:when test = "${currentMember.memberId == book.memberId}">
			            	<a href="#">Delete</a>
			         	</c:when>
						<c:otherwise>
						
							<a href="#">Signup/Cancel</a>
						
						</c:otherwise>
		      		</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>