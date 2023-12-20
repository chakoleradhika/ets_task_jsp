

<%@page import="com.ty.employeemanagemanesystem.dto.Employee"%>
<%@page import="com.ty.employeemanagemanesystem.dao.EmployeeDao"%>
<%@page import="java.util.List"%>

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
margin-left: 20%;
}

</style>
</head>
<body bgcolor="#C3E2C2">
	<%!
	
	EmployeeDao empDao = new EmployeeDao();
	List<Employee> employees = empDao.getAllEmployee();
	
	%>
	<div class="main">
	
	<center><h1>Employee Summary</h1></center>
	<table cellspacing="60px" cellpadding="5px">
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>contact</th>
	<th>Salary</th>
	</tr>
	
	<%
	for(Employee emp : employees)
	{
	%>
	
	<tr>
	<td><%= emp.getId() %></td>
	<td><%= emp.getName() %></td>
	<td><%= emp.getEmail() %></td>
	<td><%= emp.getContact() %></td>
	<td><%= emp.getSalary() %></td>
	</tr>
	<% 
	}
	%>
	
	</table>
	</div>
	
	<br><br>
	
</body>
</html>