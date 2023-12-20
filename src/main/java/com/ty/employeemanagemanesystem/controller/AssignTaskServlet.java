package com.ty.employeemanagemanesystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.employeemanagemanesystem.dao.EmployeeDao;
import com.ty.employeemanagemanesystem.dao.TaskDao;
import com.ty.employeemanagemanesystem.dto.Employee;
import com.ty.employeemanagemanesystem.dto.Task;

@WebServlet(value="/assignTask")
public class AssignTaskServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String empId= req.getParameter("empid");
		String taskId= req.getParameter("taskid");
		
		int emp_id = Integer.parseInt(empId);
		int task_id = Integer.parseInt(taskId);
		
		PrintWriter writer = resp.getWriter();
		EmployeeDao empDao = new EmployeeDao();
		Employee emp=empDao.findEmployee(emp_id);
		
		RequestDispatcher rd = null;
		if(emp != null)
		{
			TaskDao taskDao = new TaskDao();
			Task task= taskDao.findTask(task_id);
			
			if(task != null)
			{
				empDao.AssignTask(emp,task);
				rd= req.getRequestDispatcher("Emp_Task.jsp");
				
				req.setAttribute("Employee", emp);
				req.setAttribute("Task", task);
				
				rd.forward(req, resp);
			}
			else
			{
				writer.print("<h2>Task id not found</h2>");
				rd = req.getRequestDispatcher("AssignTask.html");
			}
		}else
		{
			writer.print("<h2>Employee ID not found</h2>");
			rd= req.getRequestDispatcher("AssignTask.html");
			rd.include(req, resp);
			 
		}
	}

}
