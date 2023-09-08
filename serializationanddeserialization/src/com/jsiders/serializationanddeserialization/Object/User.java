package com.jsiders.serializationanddeserialization.Object;

import java.io.Serializable;

public class User implements Serializable{
	private static final long SerialVersionID = 1L;
	private int id;
	private String username;
	private String user;
	private String password;
	
	public void SetId (int id) {
		this.id = id;
	}
	public void SetUsername(String username) {
		this.username = username;
	}
	public void SetUser(String user) {
		this.user = user;
	}
	public void SetPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", user=" + user + ", password=" + password + "]";
	}
}
