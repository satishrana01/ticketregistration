package com.ticketregistration.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticketregistration.db.DBHandling;
import com.ticketregistration.db.TicketRegistration;

import static com.ticketregistration.controller.TicketController.DBPATH;

@WebServlet("/checkuser")
public class CheckUserController extends HttpServlet { 

	private static final long serialVersionUID = -2090339709628665519L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DBPATH = getServletContext().getRealPath("resources");
		TicketRegistration model = new TicketRegistration();
		String responseString = "";
		DBHandling dbOperation = new DBHandling();
		String emailsignup = request.getParameter("emailsignup");
		model.setEmailsignup(emailsignup);
		boolean userStatus = dbOperation.getUser(model);
		
		if (userStatus) {
			
			responseString = "User already exist.";
		} 
		
		response.setContentType("text/plain");
		response.getWriter().write(responseString);
		

	}
}
