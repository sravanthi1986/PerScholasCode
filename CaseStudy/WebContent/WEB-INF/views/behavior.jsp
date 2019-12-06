<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Raising kids:Behavior</title>
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
<div id="banner-wrapper">
			<div id="banner" class="box container" >
				<div class="row">
					<div class="col-7 col-12-medium">
						<h2>Behavior Tips</h2>
						<p>For kids</p>
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

									<h2>Behavoir For Kids</h2>

									<p>DO:<br>
Encourage your child and give lots of affection.<br>

Praise your child and give extra attention when he or she does something right.<br>Give a reward for good behavior.

<br>Your child will copy your actions and words. <br>Act and speak the way you want your child to act and speak.

Be kind, but firm.<br>

Remove temptations (like breakable items) before children get into trouble.<br> Preventing bad behavior is always easier than correcting a problem.

<br>Ignore some small problems or annoying behaviors. <br>Bigger problems need to be corrected, especially if the child's bad behavior might be harmful or dangerous.

Be consistent. <br>Always treat a bad behavior the same way, or your child will learn that he or she can sometimes “get away with it.”
<br>
Correct your child soon after the bad behavior occurs, but wait until your anger has passed. Counting to 10 before you say something or do something may help reduce your anger so you are in control of yourself.

</p>

									<h3>Please never use "Don't" for kids</h3>
									<p>DON'T:<br>
Don't nag or talk about bad behavior too much. Children ignore nagging.<br>

Don't try reasoning to get your point across to children younger than three or four years,They won't understand.

Don't criticize your child.<br>

Don't call your child names.<br>

Don't call your child “bad.” Only the behavior is bad.<br>

Don't scold too often. Scolding makes children anxious and may make them ignore you. It may also worsen the behavior. Never scold your child during time-out.<br>

Don't spank. Spanking teaches your child that it's okay to hit someone in order to solve a problem. Never spank a child who is younger than 18 months. It doesn't help, and you may hurt the child. Never spank a child when you're angry. Never hit your child with an object.<br>

Don't pull your child's hair, jerk an arm, or shake your child.</p>

																	</article>

						</div>
					</div>
				</div>
<%@include file="comments.jsp"%>
		<%@include file="footer.jsp"%>
			
		
			</div>


	</body>
</html>