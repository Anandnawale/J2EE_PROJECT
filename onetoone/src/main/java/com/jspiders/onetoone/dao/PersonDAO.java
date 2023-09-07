package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.AadharCard;
import com.jspiders.onetoone.dto.Person;


public class PersonDAO {
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
		
		Person person = new Person();
		person.setId(5);
		person.setName("Anand");
		person.setEmail("anandnawale@gmail.com");
		
		AadharCard aadharCard = new AadharCard();
		aadharCard.setId(5);
		aadharCard.setAadharNumber(422578941024l);
		aadharCard.setDateOfIssue("01/02/2022");
		
		entityManager.persist(aadharCard);
		person.setAadharCard(aadharCard);
		entityManager.persist(person);
		
		entityTransaction.commit();
		closeConnection();
	  }
}
