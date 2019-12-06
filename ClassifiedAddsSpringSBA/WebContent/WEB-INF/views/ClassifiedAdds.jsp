<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classified Adds</title>
</head>
<body>
	<h1>Classified Adds</h1>
	<fieldset>
		<legend>Create a listing</legend>
		<form:form action="${pageContext.request.contextPath}/order" 
		method="post" modelAttribute="item">
			<div>
			Item: <input type = "text" name = "item">
               <div>
                   <form:input path="item" value="text"/>
                   <p style="color:red;"><form:errors path="item" class="error"/></p>
               </div>
           </div>
           <div>
               Price: <input type = "text" name = "price">
               <div>
                   <form:input path="price"/>
                   <p style="color:red;"><form:errors path="price" class="error"/></p>
               </div>
           </div>
 
			<input type="submit" value="createListing" />
		</form:form>
	</fieldset>
	<fieldset>
		<legend>Listing</legend>
		<table>
			<tr>
				<th>Item</th>
				<th>Price</th>

			</tr>
			<c:forEach items="${allItems}" var="item">
				<tr>

					<td>${item.item}</td>
					<td>${item.price}</td>
					<td><a
						href="${pageContext.request.contextPath}/order/${item.item}">Order</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>