package com.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.User;

public class Mapper {
	
	public ObjectMapper getMapper(User user,String response){
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.readValue(response, User.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectMapper;
	}


}
