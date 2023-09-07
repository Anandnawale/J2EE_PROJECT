package com.jspiders.onetomany.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.School;
import com.jspiders.onetomany.dto.Student;

public class SchoolDAO {
	 private static EntityManagerFactory entityManagerFactory;
	 private static EntityManager entityManager;
	 private static EntityTransaction entityTransaction;
	 
	 
	 private static void openConnection() {
		 entityManagerFactory = Persistence.createEntityManagerFactory("person");
		 entityManager = entityManagerFactory.createEntityManager();
		 entityTransaction = entityManager.getTransaction();
	 } 
	 private static void closeConnection() {
		 if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		 if (entityManager != null) {
			entityManager.close();
		}
		 if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
	     }
	 }
	 public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
	     School school = new School();
	     school.setName("ABC");
	     school.setAddress("pune");
	     
	     Student student1 = new Student();
	     student1.setName("Anand");
	     student1.setEmail("anand@gmail.com");
	     
	     Student student2 = new Student();
	     student2.setName("Bharat");
	     student2.setEmail("bharat@gmail.com");
	     
	     school.setStudents(Arrays.asList(student1,student2));
		
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(school);
		
		entityTransaction.commit();
		closeConnection();
			
	}
}
