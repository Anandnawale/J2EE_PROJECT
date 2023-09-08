package com.jsiders.serializationanddeserialization;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long SerialVersionID = 1L;
	
	private int id;
	private String email;
	private int age;
	private String name;
	
	public Student(int id,String name,String email,int age) {
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.age=age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", age=" + age + ", name=" + name + "]";
	}
}
