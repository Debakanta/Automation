package com.utils;

public class HelperClassPayload {

	public static String body(String name,String job) {
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return requestBody;
		
	}
	
}
