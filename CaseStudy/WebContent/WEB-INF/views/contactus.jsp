<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Contact us</title>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<spring:url value="/resources/css/main2.css" />"
	rel="stylesheet" />
<script type="text/javascript"
	src="<spring:url value="/resources/js/main.js" />"></script>
	<style>
	#banner{
	    background-image: url(/CaseStudy/resources/images/img_bg_1.jpg);
        display: block;
	}
	.row > .col-4 {
			width: 25%; 
		}
	
	</style>
</head>
	<body class="is-preload no-sidebar">
		<div id="page-wrapper">

<%@include file="header.jsp"%>


			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						<div id="content">

							<!-- Content -->
								<article>

									<div class="column middle">
			<h2>Contact us</h2>
			<p>Welcome to Raisingkids.com! We're here to help moms and dads
				raise happy, healthy kids - and have some A LOT of fun along the
				way. We also happen to be the online home of Parents, FamilyFun,
				American Baby, and Parents Latina magazines.</p>
			<p>For more details...you can contact us...</p>
			<p>
				Sravs,<br>1234dallas parkway,<br>Frisco,<br>contactNo123456789
			</p>
		</div>

								</article>

						</div>
					</div>
				</div>
		<%@include file="footer.jsp"%>
			
		
			</div>


	</body>
</html>