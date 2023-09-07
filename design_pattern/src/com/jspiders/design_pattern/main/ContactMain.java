package com.jspiders.design_pattern.main;

import com.jspiders.design_pattern.creational.Contact;
import com.jspiders.design_pattern.creational.ContactBuilder;

public class ContactMain {

	public static void main(String[] args) {

		Contact contact = new ContactBuilder().firstName("Elon").lastName("Musk").mobileNumber(9876543210l)
				.getContact();
		System.out.println(contact);

	}

}