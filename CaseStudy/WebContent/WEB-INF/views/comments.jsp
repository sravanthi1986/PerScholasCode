<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<h1>Comments</h1>
<ul>
<c:forEach items="${comments}" var="comments">
				
					<li>${comments.comment}</li>
					
		
				
</c:forEach>
</ul>
</div>

 <form action="${pageContext.request.contextPath}/comments" method="post">
Comment: <input type="text" name="comments">
<input type="hidden" name="articleUrl" value="${articleURL}">
<button>Enter</button>
</form>
