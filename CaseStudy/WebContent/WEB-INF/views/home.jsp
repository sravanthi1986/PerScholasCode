<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Raising Kids:Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<%@include file="header.jsp"%>

<img alt="boraji.com" src="<spring:url value="/resources/images/familypic.PNG"/>" width="200">

	<div class="row">

		<div class="column middle">
			<h2>Welcome</h2>
			<p>Welcome to Raisingkids.com! We're here to help moms and dads raise happy, healthy kids - and have some A LOT of fun along the way. We also happen to be the online home of Parents, FamilyFun, American Baby, and Parents Latina magazines.</p>
		</div>


	</div>

	<%@include file="footer.jsp"%>

</body>
</html>

