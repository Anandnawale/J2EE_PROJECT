package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore.beans.StudentBean;
import com.jspiders.springcore.config.StudentConfig;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		
		StudentBean student1 = context.getBean(StudentBean.class);
		
		System.out.println(student1);
		
		((AnnotationConfigApplicationContext)context).close();
	}
}
