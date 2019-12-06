<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>


.dropbtn {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown:hover .dropbtn {
	background-color: red;
}

li.dropdown {
	display: inline-block;
	
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
	line-height:2.5em;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
<!-- Header begins -->
<div id="header-wrapper">
	<header id="header" class="container">

		<!-- Logo -->
		<div id="logo">
			<h1>
				<a href="${pageContext.request.contextPath}">Raising Kids</a>
			</h1>

		</div>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/articles/parents">Parents</a></li>
				<li><a
					href="${pageContext.request.contextPath}/articles/education">Education</a></li>
				<li><a
					href="${pageContext.request.contextPath}/articles/behavior">Behavior</a></li>
				<li><a href="${pageContext.request.contextPath}/articles/tips">Tips</a></li>
				<li><a href="${pageContext.request.contextPath}/contactus">Contact
						us</a></li>

				<% if(session.getAttribute("currentUserName") == null){ %>

				<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				<% }else{ %>
				<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">My Account</a>
					<div class="dropdown-content">
						<a href="${pageContext.request.contextPath}/editprofile">Edit profile</a> 
						<a href="${pageContext.request.contextPath}/logout">Log out</a>
					</div> <%} %>
			</ul>
		</nav>

	</header>
</div>
<!-- Header End -->