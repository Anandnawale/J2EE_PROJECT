package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.Company;
import com.jspiders.onetomany.dto.Employee;


public class CompanyDAO {
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
		
		Company company = new Company();
		company.setId(9);
		company.setName("Accenture");
		company.setAddress("pune");
		company.setEmail("accenture@gmail.com");
		
		Employee emp1 = new Employee();
		emp1.setId(8);
		emp1.setName("Pankaj");
		emp1.setEmail("pankaj@gmail.com");
		emp1.setSalary(35000.00);
		
		Employee emp2= new Employee();
		emp2.setId(10);
		emp2.setName("Avinash");
		emp2.setEmail("Avinash@gmail.com");
		emp2.setSalary(50000.00);
		
		Employee emp3= new Employee();
		emp3.setId(11);
		emp3.setName("Akash");
		emp3.setEmail("Akash@gmail.com");
		emp3.setSalary(45000.00);
		
		List<Employee> employee = new ArrayList<>();
		
		employee.add(emp1);
		employee.add(emp2);
		employee.add(emp3);
		
		company.setEmployee(employee);
		
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(emp3);
		entityManager.persist(company);
		
		entityTransaction.commit();
		closeConnection();
			
	}
}
