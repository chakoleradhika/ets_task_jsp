package com.ty.employeemanagemanesystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.employeemanagemanesystem.dao.EmployeeDao;
import com.ty.employeemanagemanesystem.dto.Employee;

@WebServlet(value="/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password= req.getParameter("password");
		
		EmployeeDao empDao= new EmployeeDao();
		Employee emp = empDao.Login(email,password);
		
		if(emp != null)
		{
			HttpSession session = req.getSession();
			session.setAttribute("employee", emp);
			if(emp.getRole().equals("Manager"))
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("ManagerAccount.jsp");
				dispatcher.forward(req, resp);
			}else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("EmployeeAccount.jsp");
				dispatcher.forward(req, resp);
			}
		}else
		{
			PrintWriter writer = resp.getWriter();
			writer.print("Invalid credetial");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
			dispatcher.include(req, resp);
		}
	}

}
