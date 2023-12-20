<%@page import="com.ty.employeemanagemanesystem.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

h1 {
	padding: 10px;
}

.profile {
	height: 400px;
	width: 40%;
	margin-left: 30px;
	margin-top: 30px;
	display: inline-block;
	background-color: #EEF0E5;
}

.profile table {
	margin-top: 30px;
	padding-left: 20%;
}

.profile table td {
	font-size: larger;
	font-weight: bold;
}

.operation {
	width: 55%;
	display: inline;
	margin-top: 30px;
	display: inline-block;
}

.operation ul li {
	display: inline;
	padding-left: 50px;
	justify-content: space-between;
}

.operation ul li a {
	padding: 8px 8px 8px 8px;
	background-color: #607274;
	font-size: 20px;
	text-decoration: none;
	color: black;
}
</style>
</head>
<body bgcolor="#C3E2C2">

	<%
	Employee emp = (Employee) request.getAttribute("employee");
	%>

	<center>
		<h1 style="background-color: black; color: white;">Manager
			DashBoard</h1>
	</center>

	<div class="profile">

		<center>
			<h1 style="background-color: #607274;">Profile</h1>
		</center>

		<table cellspacing="15px">

			<tr>
				<td>Employee ID</td>
				<td><%=emp.getId()%></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><%=emp.getName()%></td>
			</tr>
			<tr>
				<td>Employee Email</td>
				<td><%=emp.getEmail()%></td>
			</tr>
			<tr>
				<td>Employee contact</td>
				<td><%=emp.getContact()%></td>
			</tr>

			<tr>
				<td>Employee Role</td>
				<td><%=emp.getRole()%></td>
			</tr>

			<tr>
				<td>Employee Salary</td>
				<td><%=emp.getSalary()%></td>
			</tr>


		</table>

	</div>

	<div class="operation">

		<ul type="none">
			<li><a href="CreateTask.html">create task</a></li>
			<li><a href="AssignTask.html">assign task</a></li>
			<li><a href="ViewAllTask.jsp">view all task</a></li>
			<li><a href="ViewAllEmployee.jsp">view all employee</a></li>
			<li><a href="logout">logout</a></li>
		</ul>


	</div>
</body>
</html>