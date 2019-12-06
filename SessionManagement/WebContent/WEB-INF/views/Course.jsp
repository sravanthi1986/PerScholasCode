<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="java.util.ArrayList" import="org.servlet.Course" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
ArrayList<Course> courselist = (ArrayList<Course>) request.getAttribute("courseList");
String schoolName = request.getAttribute("schoolName").toString();
%>

<table>
<tr> <% out.print(schoolName); %>
<%for(Course course: courselist){ %>
<tr>
<td><%=course.getCourseId() %> </td>
<td><%=course.getName() %> </td>
<td><%=course.getDescription() %> </td>
</tr>
<% } %>
</tr>

</table>

</body>
</html>