package com.happn.techtest.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.happn.techtest.dto.requests.POIRequest;
import com.happn.techtest.dto.responses.NumberPOIResponse;

@Component
public class NumberOfPoiWS extends WSConfig {

	private static final Logger logger = LoggerFactory.getLogger(NumberOfPoiWS.class);

	public void callWS(HttpEntity<POIRequest> entity) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<NumberPOIResponse> v = restTemplate.exchange(env.getProperty("server.adress")+ ":" + env.getProperty("server.port")
		+ "/" + env.getProperty("ws.poi.endpoint"), HttpMethod.POST, entity
		, NumberPOIResponse.class);

		try {
			System.out.println(mapResponse(v));
		} catch (JsonProcessingException e) {
			logger.error("JSON Parser", "Error parsing data" ,e);
		}
	}

}
