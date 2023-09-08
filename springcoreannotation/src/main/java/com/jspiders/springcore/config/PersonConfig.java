package com.jspiders.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspiders.springcore.beans.PersonBean;

@ComponentScan("com.jspiders.springcore")

public class PersonConfig {
	
	@Bean
	
	public PersonBean getPerson(){
		return new PersonBean();
		
	}
}
