<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Snacks</title>
</head>
<body>
	<h1>Snacks</h1>
	<fieldset>
		<legend>Snack Form</legend>
		<form:form action="${pageContext.request.contextPath}/addSnack" method="post" modelAttribute="snack">
			<div>
				<label for="snacksname">SnackName</label>
				<div>
					<form:input path="snacksname"/>
					<p style="color:green;"><form:errors path="snacksname" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="studentname">StudentName</label>
				<div>
					<form:input path="studentname"/>
					<p style="color:red;"><form:errors path="studentname" class="error"/></p>
				</div>
			</div>
			<input type="submit" value="addSnack" />
		</form:form>
	</fieldset>
	<fieldset>
		<legend>Snack List</legend>
		<table>
			<tr>
				<th>Snack Id</th>
				<th>Snack Name</th>
				<th>Student Name</th>
			</tr>
			<c:forEach items="${allSnacks}" var="snack">
				<tr>
					<td>${snack.snacksid}</td>
					<td>${snack.snacksname}</td>
					<td>${snack.studentname}</td>
					<td><a href="${pageContext.request.contextPath}/signup/${snack.snacksid}">Signup</a></td>
					<td><a href="${pageContext.request.contextPath}/cancelSignup/${snack.snacksid}">Cancel</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>