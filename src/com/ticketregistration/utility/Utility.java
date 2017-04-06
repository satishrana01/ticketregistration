package com.ticketregistration.utility;

import java.util.UUID;

public class Utility {

	public static String getPassword(){
		
		String randomStr = UUID.randomUUID().toString();
		return  randomStr;
	}
	
}
