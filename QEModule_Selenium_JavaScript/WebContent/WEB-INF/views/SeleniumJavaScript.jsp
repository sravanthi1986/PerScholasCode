<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Selenium JavaScript</title>
	<script src="${pageContext.request.contextPath}/static/js/script.js"></script>
	<script>
		function createNewElement1() {
			var newElement = document.createElement("h3");
			newElement.innerHTML = "This script creates this new h3 element.";
			newElement.setAttribute("id", "header3");
			document.getElementById("scriptTextContainer").appendChild(newElement);
		}
	</script>
</head>
<body>
	<header>
		<h1>Selenium JavaScript Demonstration Page</h1>
		<a href="javascript:void(0)" id="a1" 
			onclick="document.getElementById('inlineScript').innerHTML = 
			'This text was created by an inline script.';">Inline Script</a>
		<a href="javascript:void(0)" onclick="createNewElement1();">New Element</a>
	</header>
	<div id="scriptTextContainer">
		<h3 id="inlineScript"></h3>
	</div>
</body>
</html>