<%@page import="com.ty.employeemanagemanesystem.dto.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			Task task= (Task)request.getAttribute("task");
		%>
		
		<div>
		<h1>Task Details</h1>
		
		<table>
		<tr>
		<td><b>Task ID</b></td>
		<td> <%= task.getId() %>
		</tr>
		<tr>
		<td><b>Task Description</b></td>
		<td> <%= task.getDescription() %>
		</tr>
		<tr>
		<td><b>Task Status</b></td>
		<td> <%=task.isStatus() %>
		</tr>
		
		</table>
		
		</div>
		
		<a href="AssignTask.html">AssignTask</a>
		
		<br> <br>
		
		<a href ="ManagerAccount.jsp">go to Manager Dashboard</a>
</body>
</html>