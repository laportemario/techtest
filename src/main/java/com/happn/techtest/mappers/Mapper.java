package com.happn.techtest.mappers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.happn.techtest.dto.requests.DensityRequest;
import com.happn.techtest.dto.requests.POIRequest;

@Component
public class Mapper {

	@Value("${arg.nbpoi}")
	public String nbPOI;

	@Value("${arg.densest}")
	public String densest;
	
	public POIRequest mapPOIRequestWithArgs(ApplicationArguments args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(args.getOptionValues(nbPOI).get(0), POIRequest.class);
	}

	public DensityRequest mapDensityRequestWithArgs(ApplicationArguments args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(args.getOptionValues(densest).get(0), DensityRequest.class);
	}
	
}
