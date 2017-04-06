package com.ticketregistration.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ticketregistration.utility.Constant;
import com.ticketregistration.utility.Utility;

import static com.ticketregistration.controller.TicketController.DBPATH;

public class DBHandling {

	public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(
			"dd MMM yyyy HH:mm:ss a");
	public static Connection con = null;

	public static Connection getConnection() throws Exception {
		if (con == null) {
			Class.forName("org.sqlite.JDBC");

			con = DriverManager.getConnection("jdbc:sqlite:" + DBPATH
					+ File.separator + Constant.DB_CONNECTION);
		}
		return con;
	}

	public boolean getUser(TicketRegistration model) {

		PreparedStatement stmt = null;
		boolean userStatus = false;
		try {
			;
			stmt = getConnection().prepareStatement(Constant.DB_USER);
			stmt.setString(1, model.getEmailsignup());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				userStatus = true;
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userStatus;
	}

	public TicketRegistration getUserDate(TicketRegistration model) {

		PreparedStatement stmt = null;
		
		try {
			stmt = getConnection().prepareStatement(Constant.DB_USER_DETAILS);
			stmt.setString(1, model.getEmailsignup());
			stmt.setString(2, model.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				model.setTitle(rs.getString(1));
				model.setFirstname(rs.getString(2));
				model.setLastname(rs.getString(3));
				model.setDtp_input1(rs.getString(4));
				
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	public void addDetails(TicketRegistration model) throws Exception {

		PreparedStatement stmt = null;
		model.setPassword(Utility.getPassword());
		try {

			stmt = getConnection().prepareStatement(Constant.INSERTUSER);
			stmt.setString(1, model.getEmailsignup());
			stmt.setString(2, model.getPassword());
			stmt.setString(3, model.getTitle());
			stmt.setString(4, model.getFirstname().toUpperCase());
			stmt.setString(5, model.getLastname().toUpperCase());
			stmt.setString(6, model.getPhone());
			stmt.setString(7, model.getMobile());
			stmt.setString(8, model.getAddressline1());
			stmt.setString(9, model.getAddressline2());
			stmt.setString(10, model.getTown());
			stmt.setString(11, model.getCountry());
			stmt.setString(12, model.getDtp_input1());
			stmt.setString(13, model.getPincode());
			stmt.setString(14, model.getAdultticket());
			stmt.setString(15, model.getChildticket());
			stmt.setString(16, dateFormatter.format(new Date()));
			stmt.execute();
			stmt.close();
		} catch (Exception ex) {
			throw ex;
		}

	}

}
