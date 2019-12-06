<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<spring:url value="/resources/css/main.css" />" rel="stylesheet" />
<script type="text/javascript"  src="<spring:url value="/resources/js/main.js" />"></script>
<div class="header">
<a href="${pageContext.request.contextPath}"><img class="logo" src="<spring:url value="/resources/images/logo.jpg"/>" />
</a>
  <h1>Raising Kids</h1>
  <p>Better Parenting</p>
</div>

<div class="topnav">
  <a href="${pageContext.request.contextPath}/articles/parents">Parents</a>
  <a href="${pageContext.request.contextPath}/articles/education">Education</a>
  <a href="${pageContext.request.contextPath}/articles/behavior">Behavior</a>
  <a href="${pageContext.request.contextPath}/articles/tips">Tips</a>
  "WebContent/WEB-INF/views/comments.jsp"
  
   <% if(session.getAttribute("currentUserName") == null){ %> 
 
  <a href="${pageContext.request.contextPath}/login">Login</a>
  <% }else{ %>
  <a href="${pageContext.request.contextPath}/logout">Logout</a>
  <%} %>
</div>