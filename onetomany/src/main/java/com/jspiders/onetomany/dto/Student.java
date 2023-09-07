package com.jspiders.onetomany.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Student_info")

public class Student {

	@Id
	@Column(name = "Student_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Student_name")
	private String name;
	@Column(name = "Student_email")
	private String email;
	
	
}
