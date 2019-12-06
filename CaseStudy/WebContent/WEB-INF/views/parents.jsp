<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Raising kids : Parents</title>
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
						<h2>Parents Tips</h2>
						<p>for parents</p>
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

									<h2>How To Be with Kids..</h2>

									<p>Boosting Your Child's Self-Esteem. ...<br>
Catch Kids Being Good. ...<br>
Set Limits and Be Consistent With Your Discipline. ...<br>
Make Time for Your Kids. ...<br>
Be a Good Role Model. ...<br>
Make Communication a Priority. ...<br>
Be Flexible and Willing to Adjust Your Parenting Style..</p>

									<h3>More information.....</h3>
									<p>No parent is perfect.<br>

No child is perfect either … keeping this in mind is important when we set our expectations.<br>

But it doesn’t mean that we shouldn’t work towards that goal.<br>

Set high standards for ourselves first and then our children second. We serve as a role model for them.<br>

Here are 10 tips on learning effective parenting skills.<br>

Many of them are not quick nor easy. And probably no one can do all of them all of the time.<br>

But if you can keep working on them, even though you may only do part of these some of the time, you will still be moving in the right direction.<br>

Top 10 Tips On Improving Parenting Skills<br>
#1 Be A Good Role Model<br>
#2: Love Them And Show Them Through Action<br>
#3: Practice Kind And Firm Positive Parenting<br>
#4: Be A Safe Haven For Your Child<br>
#5: Talk With Your Child And Help Their Brains Integrate<br>
#6: Reflect On Your Own Childhood<br>
#7: Pay Attention To Your Own Well-Being<br>
#8: Do Not Spank, No Matter What<br>
#9: Keep Things In Perspective And Remember Your Parenting Goal<br>
#10: Take A Shortcut By Utilizing Findings In Latest Psychology And Neuroscience Research<br>
</p>

									
								</article>

						</div>
					</div>
				</div>
<%@include file="comments.jsp"%>
		<%@include file="footer.jsp"%>
			
		
			</div>


	</body>
</html>