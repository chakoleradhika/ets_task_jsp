package com.ty.employeemanagemanesystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.employeemanagemanesystem.dao.TaskDao;
import com.ty.employeemanagemanesystem.dto.Task;

@WebServlet(value="/createtask")
public class CreateTaskServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String desc = req.getParameter("desc");
		String stts = req.getParameter("status");
		boolean status = false;

		if (stts.equals("created")) {

		}

		// creating the task object
		Task task = new Task();
		// setting the attributes to the task
		task.setDescription(desc);
		task.setStatus(status);

		TaskDao taskDao = new TaskDao();
		taskDao.createTask(task);
	}

}
