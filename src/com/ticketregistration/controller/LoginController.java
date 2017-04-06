package com.ticketregistration.controller;

import static com.ticketregistration.controller.TicketController.DBPATH;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticketregistration.db.DBHandling;
import com.ticketregistration.db.TicketRegistration;

@WebServlet("/validateuser")
public class LoginController extends HttpServlet { 

	private static final long serialVersionUID = 1470284867425585104L;
public static final String SPACE = " ";
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DBPATH = getServletContext().getRealPath("resources");
		
		StringBuilder userResponse = new StringBuilder("Incorrect username or password.");
		TicketRegistration model = new TicketRegistration();
		DBHandling dbOperation = new DBHandling();
		String emailsignup = request.getParameter("emailsignup");
		String password = request.getParameter("password");
		model.setEmailsignup(emailsignup);
		model.setPassword(password);
		
		
		TicketRegistration userData = dbOperation.getUserDate(model);
		
		if (userData.getLastname() != null && !userData.getLastname().isEmpty()) {
			
			userResponse.setLength(0);
			userResponse.append("Welcome,").append(SPACE).append(model.getTitle()).append(SPACE);
			userResponse.append(model.getFirstname() != null ? model.getFirstname() : "").append(SPACE).append(model.getLastname()).append("\n");
			userResponse.append("Registered on: ").append(SPACE).append(model.getDtp_input1());
			
		} 
		
		response.setContentType("text/plain");
		response.getWriter().write(userResponse.toString());
		

	}
}
