package com.ty.employeemanagemanesystem.dao;

import java.util.List;

import javax.persistence.Query;

import com.ty.employeemanagemanesystem.dto.Employee;
import com.ty.employeemanagemanesystem.dto.Task;

public class EmployeeDao 
{
	public void register(Employee emp)
	{
		Helper.getTransaction().begin();
		
		Helper.getManager().persist(emp);
		
		Helper.getTransaction().commit();
	}

	public Employee Login(String email, String password) {
		Query query = Helper.getManager().createQuery("SELECT E FROM Employee E WHERE E.email=?1 AND E.password=?2");
		
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Employee> emps=query.getResultList();
		if(!emps.isEmpty())
		{
			return emps.get(0);
		}
		return null;
	}

	public Employee findEmployee(int emp_id) {
		return Helper.getManager().find(Employee.class, emp_id);
	}

	public void AssignTask(Employee emp, Task task) {
		List<Task> tasks= emp.getTasks();
		tasks.add(task);
		
		emp.setTasks(tasks);
		
		Helper.getTransaction().begin();
		
		Helper.getManager().merge(emp);
		
		Helper.getTransaction().commit();
		
	}
	
	public List<Employee> getAllEmployee()
	{
		Query query = Helper.getManager().createQuery("SELECT E FROM Employee E");
		
		return query.getResultList();
	}

}
