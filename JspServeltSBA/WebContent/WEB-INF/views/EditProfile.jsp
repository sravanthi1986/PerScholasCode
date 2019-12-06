
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Update</title>
</head>
<body>
   <h1>User Update</h1>
<form action="${pageContext.request.contextPath}/loginServlet/updateUser" method="post">
<div>
           <label>User Id:</label>
           <input type="hidden" name="userId" value="${currentUser.userId}"/>
       </div>
       <div>
           <label>User Name:</label>
           <input name="userName" value="${currentUser.userName}"/>
       </div>
       <div>
           <label>Password:</label>
           <input name="password" value="${currentUser.password}"/>
       </div>
       <div>
           <input type=submit value="Update" />
       </div>
   </form>
   <a href="${pageContext.request.contextPath}/loginServlet/showProfile">Back to User Profile</a>
</body>
</html>
