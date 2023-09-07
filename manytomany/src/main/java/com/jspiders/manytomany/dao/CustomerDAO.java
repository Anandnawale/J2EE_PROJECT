package com.jspiders.manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.Customer;
import com.jspiders.manytomany.dto.Product;

public class CustomerDAO {
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
		
	    Customer customer1 = new Customer();
	    customer1.setId(2);
	    customer1.setName("Smith");
	    customer1.setEmail("smith@gmail.com");
	    customer1.setAddress("Pune");
	    
	    Customer customer2 = new Customer();
	    customer2.setId(3);
	    customer2.setName("Akash");
	    customer2.setEmail("akash@gmail.com");
	    customer2.setAddress("mumbai");
	    
	    Product product1 = new Product();
	    product1.setId(2);
	    product1.setName("Dell");
	    product1.setPrice(15000.00);
	    
	    Product product2 = new Product();
	    product2.setId(3);
	    product2.setName("Lenovo");
	    product2.setPrice(60000.00);
	    
	    List<Customer> customers1 = new ArrayList<>();
	    customers1.add(customer1);
	    
	    List<Customer> customers2 = new ArrayList<>();
	    customers2.add(customer1);
	    customers2.add(customer2);
	    
	    List<Product> products1 = new ArrayList<>();
	    products1.add(product2);
	    
	    List<Product> products2 = new ArrayList<>();
	    products2.add(product1);
	    products2.add(product2);
	    
	    customer1.setProducts(products1);
	    customer2.setProducts(products2);
	    
	    product1.setCustomers(customers2);
	    product2.setCustomers(customers1);
	    
	    entityManager.persist(product1);
	    entityManager.persist(product2);
	    entityManager.persist(customer1);
	    entityManager.persist(customer2);
	    
		entityTransaction.commit();
		closeConnection();
	 }
}
