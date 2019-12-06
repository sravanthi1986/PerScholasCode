<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Raising kids:Tips</title>
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
						<h2>Tips</h2>
						<p>For Parents and Kids</p>
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

									<h3>Be a Good Role Model:</h3>

									<p>
Be the role model your children deserve. Kids learn by watching their parents. Modeling appropriate, respectful, good behavior works much better than telling them what to do.<br>

Fess up when you blow it. This is the best way to show your child how and when she should apologize.</p>

									<h3>Know the Best Ways to Praise</h3>
									<p>Trust Yourself:<br>
Give yourself a break. Hitting the drive-through when you're too tired to cook doesn't make you a bad parent.<br>

Trust your mommy gut. No one knows your child better than you. <br>Follow your instincts when it comes to his health and well-being. If you think something's wrong, chances are you're right.<br>

Just say "No." Resist the urge to take on extra obligations at the office or become the Volunteer Queen at your child's school. <br>You will never, ever regret spending more time with your children.<br>

Don't accept disrespect from your child. Never allow her to be rude or say hurtful things to you or anyone else. <br>If she does, tell her firmly that you will not tolerate any form of disrespect.<br>

Pass along your plan. Mobilize the other caregivers in your child's life -- your spouse, grandparents, daycare worker, babysitter -- to help reinforce the values and the behavior you want to instill. This includes everything from saying thank you and being kind to not whining.</p>

					

								</article>

						</div>
					</div>
				</div>
<%@include file="comments.jsp"%>
		<%@include file="footer.jsp"%>
			
		
			</div>


	</body>
</html>