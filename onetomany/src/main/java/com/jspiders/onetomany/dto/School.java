package com.jspiders.onetomany.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "School_info")

public class School {
 
	@Id
	@Column(name = "School_id")
	private int id;
	@Column(name = "School_name")
	private String name;
	@Column(name = "School_address")
	private String address;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Student> students;
	
}
