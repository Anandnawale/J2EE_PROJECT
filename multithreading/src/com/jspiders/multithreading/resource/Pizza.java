package com.jspiders.multithreading.resource;

public class Pizza {
   private int availablepizza;
   public synchronized void OrderPizza(int orderpizza) {
	   System.out.println("Trying to order"+orderpizza+"Pizzas.");
	   if (availablepizza<orderpizza) {
		System.out.println(orderpizza+"Pizza not available please wait__");
	}
	   else {
		 try {
			this.wait();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	   availablepizza -=orderpizza;
	   System.out.println(orderpizza+"Pizza Delivered");
	   System.out.println(availablepizza+"Pizza Available__");
   }
   public synchronized void BakedPizza(int bakedpizza) {
	   System.out.println("Baking"+bakedpizza+"pizza");
	   availablepizza += bakedpizza;
	   System.out.println(bakedpizza+"Pizza Baked");
	   System.out.println(availablepizza+"Pizza Available");
	   this.notify();
     }
   }
