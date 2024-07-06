package com.jspid.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Hibernate_Utility {
	public static EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");
	public static EntityManager entityManager = createEntityManagerFactory.createEntityManager();
	public static EntityTransaction transaction = entityManager.getTransaction();
}
