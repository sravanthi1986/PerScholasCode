<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Raising kids:Home Page</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link href="<spring:url value="/resources/css/main2.css" />"
	rel="stylesheet" />
<script type="text/javascript"
	src="<spring:url value="/resources/js/main.js" />"></script>
<style>
#banner {
	background-image: url(/CaseStudy/resources/images/img_bg_1.jpg);
	display: block;
}

.row>.col-4 {
	width: 25%;
}
</style>
</head>
<body class="is-preload homepage">
	<div id="page-wrapper">

		<%@include file="header.jsp"%>
		<!-- Banner -->
		<div id="banner-wrapper">
			<div id="banner" class="box container">
				<div class="row">
					<div class="col-7 col-12-medium">
						<h2>Welcome Parents</h2>
						<p>Are you excited to see my tips....</p>
					</div>

				</div>
			</div>
		</div>

		<!-- Features -->
		<div id="features-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-4 col-12-medium">

						<!-- Box -->
						<section class="box feature">
							<a href="#" class="image featured"><img
								src="/CaseStudy/resources/images/education.JPG" alt="" /></a>
							<div class="inner">
								<header>
									<h2>Kids Education</h2>
									<p>Here is ideas to make easy</p>
								</header>
								<p>As kids make the transition from toddlerhood to childhood, they grow at a remarkable rate. Their cognitive and language skills develop dramatically during these years, During these years children also have fears Whatever your role in a child's life, you can make learning productive and enjoyable for both of you.</p>
							</div>
						</section>

					</div>
					<div class="col-4 col-12-medium">

						<!-- Box -->
						<section class="box feature">
							<a href="#" class="image featured"><img
								src="/CaseStudy/resources/images/holidays.JPG" alt="" /></a>
							<div class="inner">
								<header>
									<h2>Holidays</h2>
									<p>It Is Pain for Moms</p>
								</header>
								<p>For the next several weeks, you may have high expectations for good, cooperative behavior. You may get tired of expensive or so very many gifts. Comments from relatives at family gatherings may trigger self-doubt.  Little elves on shelves eagerly waiting to report on good or bad behavior may be putting kids a bit on edge.

								</p>
							</div>
						</section>

					</div>
					<div class="col-4 col-12-medium">

						<!-- Box -->
						<section class="box feature">
							<a href="#" class="image featured"><img
								src="/CaseStudy/resources/images/food.JPG" alt="" /></a>
							<div class="inner">
								<header>
									<h2>Feeding Kids</h2>
									<p>It is challenging to moms</p>
								</header>
								<p>Many kids must be exposed to a new food several times before developing a taste for it. Sometimes they will surprise you and suddenly like something they previously disliked. Keep in mind that child taste buds fluctuate as they age.

Don't give kids a strong emotional reaction when they are trying a new food.</p>
							</div>
						</section>

					</div>
					<div class="col-4 col-12-medium">

						<!-- Box -->
						<section class="box feature">
							<a href="#" class="image featured"><img
								src="/CaseStudy/resources/images/health2.JPG" alt="" /></a>
							<div class="inner">
								<header>
									<h2>Behavoir..</h2>
									<p>don't use Don't for Kids</p>
								</header>
								<p>Encourage your child and give lots of affection.
Praise your child and give extra attention when kids does something right. Give a reward for good behavior.
Your child will copy your actions and words. Act and speak the way you want your child to act and speak.
Be kind, but firm.Ignore some small problems or annoying behaviors.</p>
							</div>
						</section>

					</div>
				</div>
			</div>
		</div>


     <%@include file="footer.jsp"%>
		

	</div>
</body>
</html>