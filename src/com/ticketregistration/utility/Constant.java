package com.ticketregistration.utility;

public interface Constant {

	String DB_CONNECTION = "TicketRegistraion.db";
	
	String DB_USER = "select * from users where EMAIL=?";
	String DB_USER_DETAILS = "select TITLE,FIRSTNAME,LASTNAME,DATETIME from users where EMAIL=? and PASSWORD=?";
	
	String INSERTUSER = "INSERT INTO  USERS (EMAIL,PASSWORD,TITLE,FIRSTNAME,LASTNAME,PHONE,MOBILE,ADDRESS1,ADDRESS2,TOWN,COUNTRY,DATEATTENDING,PINCODE,ADULTICKET,CHILDTICKET,DATETIME) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

}
