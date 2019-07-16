package com.happn.techtest.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class WSConfig {

	@Autowired
	protected Environment env;
	
	protected <T> String mapResponse(ResponseEntity<T> v) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(v.getBody());
	}
	
}
