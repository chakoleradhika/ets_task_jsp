<%@page import="com.ty.employeemanagemanesystem.dto.Task"%>
<%@page import="com.ty.employeemanagemanesystem.dto.Employee"%>
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
			Employee emp =(Employee)request.getAttribute("Employee");
			Task task =(Task) request.getAttribute("Task");
		%>
		
		<div>
			<h1>Task Description</h1>
			
			<table>
			
			<tr>
			<td>Employee Id </td>
			<td><%= emp.getId() %>
			</tr>
			<tr>
			<td>Task ID  </td>
			<td><%= task.getId() %>
			</tr>
			
			<tr>
			<td>Task Status  </td>
			<td><%= task.isStatus() %>
			</tr>
			
			</table>
		</div>
		
		<a href="AssignTask.html">go to AssignTask</a>
		
		<br><br>
		
		<a href="ManagerAccount.jsp">go to manager DashBoard</a>
</body>
</html>