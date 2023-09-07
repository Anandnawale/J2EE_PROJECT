package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.Player;
import com.jspiders.manytoone.dto.Team;

public class PlayerDAO {
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
			
			Player player1 = new Player();
			player1.setId(4);
			player1.setName("Rohit");
			player1.setJerseyNumber(45);
			player1.setAge(34);
			
			Player player2 = new Player();
			player2.setId(5);
			player2.setName("MS Dhoni");
			player2.setJerseyNumber(07);
			player2.setAge(40);
			
			Player player3 = new Player();
			player3.setId(6);
			player3.setName("Virat");
			player3.setJerseyNumber(18);
			player3.setAge(35);
			
			Team team = new Team();
			team.setId(2);
			team.setName("Team A");
			team.setCountry("India");
			
			player1.setTeam(team);
			player2.setTeam(team);
			player3.setTeam(team);
			
			entityManager.persist(team);
			entityManager.persist(player1);
			entityManager.persist(player2);
			entityManager.persist(player3);
			
			entityTransaction.commit();
			closeConnection();
 }
}
