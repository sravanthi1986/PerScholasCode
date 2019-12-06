<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.servlet.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%
Product product = (Product)request.getAttribute("product");

%>
</head>
<body>
<form action="ProductServlet" method="post">

<input type="hidden" value="<%= product.getProductId() %>" name="ProductId">
<p>ProductName:<input type="text" value="<%= product.getProductName() %>" name="ProductName"></p>
<p>ProductDescription:<input type="text" value="<%= product.getProductDescription() %>" name="ProductDescription"></p>
<input type="submit" name="Submit" value="submit">

</form>
</body>
</html>