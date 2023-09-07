package com.jspiders.multithreading.resource;

public class Account {
	
	public int balance;
	
	public Account(int balance) {
		this.balance=balance;
	}
	
	public int checkBalance() {
		
		return balance;
	}
	public void deposit(int amount) {
		System.out.println("trying to deposit:"+amount+"Rs.");
		balance+=amount;
		System.out.println("Deposit Successfuly");
		System.out.println("Account Balance:"+checkBalance());
	}
	public void withdraw(int amount) {
		System.out.println("Trying to Withdraw"+amount+"Rs.");
		if (balance >= balance) {
			balance-=amount;
			System.out.println("Withdraw succesfully");
			System.out.println("Account Balance"+checkBalance());
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
}
