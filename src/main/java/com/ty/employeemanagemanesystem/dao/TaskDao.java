package com.ty.employeemanagemanesystem.dao;

import java.util.List;

import javax.persistence.Query;

import com.ty.employeemanagemanesystem.dto.Task;

public class TaskDao {

	public void createTask(Task task) {
		Helper.getTransaction().begin();
		
		Helper.getManager().persist(task);
		
		Helper.getTransaction().commit();
		
	}

	public Task findTask(int task_id) {
		return Helper.getManager().find(Task.class, task_id);
	}
	
	public List<Task> getAllTasks()
	{
		Query query= Helper.getManager().createQuery("SELECT T FROM Task T");
		
		return query.getResultList();
	}

}
