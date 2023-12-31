package com.jspiders.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveStudent")
public class SaveStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String [] courses = req.getParameterValues("course");
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Student Info:</h1>");
		writer.println("<h2>" + name + "</h2>");
		writer.println("<h2>" + email + "</h2>");
		
		for (String course : courses) {
			writer.println("<h2>" + course + "</h2>");
		}
		
	}

}
