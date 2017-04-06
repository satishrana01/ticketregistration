package com.ticketregistration.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticketregistration.db.DBHandling;
import com.ticketregistration.db.TicketRegistration;

@WebServlet("/ticketcontroller")
public class TicketController extends HttpServlet {

	private static final long serialVersionUID = -8496769892570582197L;
	public static String DBPATH = "";

	public TicketController() {
		super();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DBPATH = getServletContext().getRealPath("resources");
		TicketRegistration model = new TicketRegistration();
		DBHandling dbOperation = new DBHandling();
		String emailsignup = request.getParameter("emailsignup");
		String title = request.getParameter("title");
		String firstname = request.getParameter("firstname") != null ? request.getParameter("firstname") :"";
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String mobile = request.getParameter("mobile");
		String addressline1 = request.getParameter("Addressline1");
		String addressline2 = request.getParameter("Addressline2");
		String town = request.getParameter("town");
		String country = request.getParameter("country");
		String dtp_input1 = request.getParameter("dtp_input1");
		String pincode = request.getParameter("pincode");
		String adultticket = request.getParameter("adultticket");
		String childticket = request.getParameter("childticket");

		model.setEmailsignup(emailsignup);
		model.setTitle(title);
		model.setFirstname(firstname);
		model.setLastname(lastname);
		model.setPhone(phone);
		model.setMobile(mobile);
		model.setAddressline1(addressline1);
		model.setAddressline2(addressline2);
		model.setTown(town);
		model.setCountry(country);
		model.setDtp_input1(dtp_input1);
		model.setPincode(pincode);
		model.setAdultticket(adultticket);
		model.setChildticket(childticket);

		boolean userStatus = dbOperation.getUser(model);

		if (userStatus) {
			
			request.setAttribute("message", "User Exists,Please try again");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		} else {
			try {
				dbOperation.addDetails(model);
				StringBuilder message = new StringBuilder("Welcome, ");
				message.append(model.getFirstname().toUpperCase()).append(" ").append(model.getLastname().toUpperCase());
				request.setAttribute("message", message.toString());
				request.setAttribute("message1", "Your passowrd is       :&nbsp;&nbsp;&nbsp;"+ model.getPassword());
				request.setAttribute("message2", "You registerd on       :&nbsp;&nbsp;&nbsp;"+new Date().toString());
				request.getRequestDispatcher("success.jsp").forward(request,response);
				} catch (Exception e) {

					e.printStackTrace();
				request.setAttribute("message", "Error occured !!");
				request.getRequestDispatcher("error.jsp").forward(request,response);
			}
		}
		
			
	
	}
}
