<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Raising kids: Education</title>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<spring:url value="/resources/css/main2.css" />"
	rel="stylesheet" />
<script type="text/javascript"
	src="<spring:url value="/resources/js/main.js" />"></script>
	<style>
	#banner{
	    background-image: url(/CaseStudy/resources/images/educationpic.jpg);
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
<div id="banner-wrapper">
			<div id="banner" class="box container" >
				<div class="row">
					<div class="col-7 col-12-medium">
						<h2>Age-by-Age Guide to Reading to Your Baby</h2>
						<p>Get your child to fall in love with reading at an early age. 

</p>
					</div>
				
				</div>
			</div>
		</div>

			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						<div id="content">
<%@include file="author.jsp"%>
							<!-- Content -->
								<article>

									<h2>The Benefits of Reading</h2>

									<p>Reading is an addiction that parents should encourage well before their baby's first birthday. The bonding experience is unbeatable, says Patricia Cowan, national program coordinator for Reach Out and Read, a project that gives children books during medical checkups. When you read to children, they're getting your full attention, and that's what they just love. Nothing -- no TV show or toy -- is better than that.
Reading to babies is also a great way to immerse them in the sounds and rhythms of speech, which is crucial for language development. In a study at Brown University School of Medicine in Providence, Rhode Island, 18- to 25-month-olds whose parents said they had been reading to them regularly for a year could say and understand more words than those whose parents hadn't. It's hard to prove whether such advantages last, but plenty of parents are convinced that early exposure to books makes a long-term difference,
both boosting children's language abilities and making them more eager to learn how to read.</p>

									<h3>10 Ways To Help Your Child Success</h3>
									<p> 1.Attend Back-to-School Night and Parent-Teacher Conferences<br>
									2. Visit the School and Its Website<br>
									3. Support Homework Expectations<br>
									4. Send Your Child to School Ready to Learn<br>
									5. Teach Organizational Skills<br>
									6. Teach Study Skills
									7. Know the Disciplinary Policies<br>
									8. Get Involved<br>
									9. Take Attendance Seriously<br>
									10. Make Time to Talk About School<br>
									
									</p>

									<p></p>

								</article>

						</div>
					</div>
				</div>
<%@include file="comments.jsp"%>
		<%@include file="footer.jsp"%>
			
		
			</div>


	</body>
</html>