<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adds</title>
</head>
<body>

<h1>Classified Adds</h1>
	<fieldset>
		<legend>Create a Listing</legend>
		<form:form action="${pageContext.request.contextPath}/addAdd" method="post" modelAttribute="add">
			<div>
				<label for="item">Item:</label>
				<div>
					<form:input path="item"/>
					<p style="color:red;"><form:errors path="item" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="price">Price: </label>
				<div>
					<form:input path="price"/>
					<p style="color:red;"><form:errors path="price" class="error"/></p>
				</div>
			</div>
			
				
			<input type="submit" value="Create Listing" />
		</form:form>
	</fieldset>
	<fieldset>
		<legend>Listings</legend>
		<table>
			<tr>		
				<th>Item</th>
				<th>Price</th>
				<th> </th>
			</tr>
			<c:forEach items="${allAdds}" var="add">
				<tr>
					<td>${add.item}</td>
					<td>${add.price}</td>
					
					<c:choose>
    				<c:when test="${add.status=='1'}">
       				 <td></td> 
   					</c:when>    
   				    <c:otherwise>
      				<td style="color:red">Sold</td>
    				</c:otherwise>
					</c:choose>
					
					<c:choose>
    				<c:when test="${add.status=='1'}">
       				 <td><a href="${pageContext.request.contextPath}/orderAdd/${add.addId}">Order</a></td> 
   					</c:when>    
   				    <c:otherwise>
      				<td><a href="${pageContext.request.contextPath}/cancelAdd/${add.addId}">Cancel</a></td>
    				</c:otherwise>
					</c:choose>
					
				</tr>
			</c:forEach>
		</table>
	</fieldset>

</body>
</html>