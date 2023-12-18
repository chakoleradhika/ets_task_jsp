package com.ty.employeemanagemanesystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Helper 
{
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
	private static EntityManager manager= factory.createEntityManager();
	private static EntityTransaction transaction = manager.getTransaction();
	
	public static EntityManager getManager()
	{
		return manager;
	}
	
	public static EntityTransaction getTransaction()
	{
		return transaction;
	}

}
