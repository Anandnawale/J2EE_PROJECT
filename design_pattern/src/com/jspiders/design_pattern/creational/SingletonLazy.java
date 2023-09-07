package com.jspiders.design_pattern.creational;

public class SingletonLazy {

	private static SingletonLazy singletonLazy;

	private SingletonLazy() {

		System.out.println("Constructor is invoked.");

	}

	public static SingletonLazy getObject() {

		if (singletonLazy == null) {
			singletonLazy = new SingletonLazy();
		}
		return singletonLazy;

	}

}