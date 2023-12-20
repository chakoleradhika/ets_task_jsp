
<%@page import="com.ty.employeemanagemanesystem.dto.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.employeemanagemanesystem.dao.TaskDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*
{
margin:0px;
padding:0px;
}

.main h1{
padding-top :4px;
padding-bottom:4px;
	background-color: black;
	color:white;
}

table{
font-size:20px;
margin-left: 30%;
}

a{
	padding: 8px 8px 8px 8px;
	background-color: #607274;
	font-size: 20px;
	text-decoration: none;
	color: black;
}
</style>
</head>
<body bgcolor="#C3E2C2">
	<%!
	
	TaskDao taskDao = new TaskDao();
	List<Task> tasks = taskDao.getAllTasks();
	
	%>
	<div class="main">
	
	<center><h1>Task Summary</h1></center>
	<table cellspacing="60px" cellpadding="5px">
	<tr>
	<th>Task Id</th>
	<th>Task Desc</th>
	<th>Task Status</th>
	</tr>
	
	<%
	for(Task task : tasks)
	{
	%>
	
	<tr>
	<td><%= task.getId() %></td>
	<td><%= task.getDescription() %></td>
	<td><%= task.isStatus() %></td>
	</tr>
	<% 
	}
	%>
	
	</table>
	</div>
	
	<center><a href="ManagerAccount.jsp">go to dashboard</a></center>
</body>
</html>