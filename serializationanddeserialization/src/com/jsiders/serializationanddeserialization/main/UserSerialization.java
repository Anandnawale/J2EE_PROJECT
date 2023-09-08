package com.jsiders.serializationanddeserialization.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.jsiders.serializationanddeserialization.Object.User;

public class UserSerialization {
	public static void main(String[] args) {
		try {
			File file = new File("user.txt");
			if (file.exists()) {
				System.out.println("File already exists");
			}
			else {
				file.createNewFile();
				System.out.println("File created succesfully");
			}
			
		    User user = new User();
			user.SetId(1);
			user.SetUsername("Akash");
			user.SetPassword("Akash@1234");
			
			FileOutputStream fileOutputStream = new  FileOutputStream(file);
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(user);
			
			System.out.println("Object written to file__");
			
			fileOutputStream.close();
			objectOutputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}