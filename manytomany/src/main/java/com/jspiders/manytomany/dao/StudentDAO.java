package com.jspiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.Course;
import com.jspiders.manytomany.dto.Student;

public class StudentDAO {
	 private static EntityManagerFactory entityManagerFactory;
	 private static EntityManager entityManager;
	 private static EntityTransaction entityTransaction;
	 
	 
	 private static void openConnection() {
		 entityManagerFactory = Persistence.createEntityManagerFactory("student");
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
		
		Course course1 = new Course();
		course1.setId(1);
		course1.setName("core java");
		course1.setFees(15000.00);
		
		Course course2 = new Course();
		course2.setId(2);
		course2.setName("sql");
		course2.setFees(10000.00);
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Rahul");
		student1.setEmail("rahul@gmail.com");
		student1.setContact(82845789l);
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Rakesh");
		student2.setEmail("rakesh@gmail.com");
		student2.setContact(95748089l);
		
		
		 List<Course> courses1 = new ArrayList<>();
	        courses1.add(course2);

	        List<Course> courses2 = new ArrayList<>();
	        courses2.add(course1);
	        courses2.add(course2);

	        student1.setCourses(courses1);
	        student2.setCourses(courses2);
		
//		List<Course>course2=ArrayList<>(course1,course2);
		
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(student1);
		entityManager.persist(student2);
		
		entityTransaction.commit();
		closeConnection();
 }
}
