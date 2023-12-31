package com.ty.employeemanagemanesystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.employeemanagemanesystem.dao.EmployeeDao;
import com.ty.employeemanagemanesystem.dto.Employee;
import com.ty.employeemanagemanesystem.dto.Task;

@WebServlet(value="/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long contact = Long.parseLong(req.getParameter("contact"));
		String password = req.getParameter("password");
		String role =req.getParameter("role");
		String sal = req.getParameter("salary");
		double salary = Double.parseDouble(sal);
		
		
		//List of Task
		List<Task> tasks= new ArrayList<>();
		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmail(email);
		emp.setContact(contact);
		emp.setPassword(password);
		emp.setRole(role);
		emp.setSalary(salary);
		emp.setTasks(tasks);
		
		EmployeeDao empDao = new  EmployeeDao();
		empDao.register(emp);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
		dispatcher.forward(req, resp);
	}

}
