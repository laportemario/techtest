package com.happn.techtest.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.happn.techtest.dto.requests.DensityRequest;
import com.happn.techtest.dto.responses.ZonesResponse;

@Component
public class ZonesByDensityWS extends WSConfig {

	private static final Logger logger = LoggerFactory.getLogger(ZonesByDensityWS.class);
	
	public void callWS(HttpEntity<DensityRequest> entity) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ZonesResponse> v = restTemplate.exchange(env.getProperty("server.adress") + ":" + env.getProperty("server.port")
		+ "/" + env.getProperty("ws.zonedensity.endpoint"), HttpMethod.POST, entity
		, ZonesResponse.class);

		try {
			System.out.println(mapResponse(v));
		} catch (JsonProcessingException e) {
			logger.error("JSON Parser", "Error parsing data" ,e);
		}
	}

}
