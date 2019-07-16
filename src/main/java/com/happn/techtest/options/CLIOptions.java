package com.happn.techtest.options;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.happn.techtest.dto.requests.DensityRequest;
import com.happn.techtest.dto.requests.POIRequest;
import com.happn.techtest.mappers.Mapper;
import com.happn.techtest.ws.NumberOfPoiWS;
import com.happn.techtest.ws.ZonesByDensityWS;

@Configuration
public class CLIOptions implements ApplicationRunner {

	@Autowired
	NumberOfPoiWS numberOfPoiWS;

	@Autowired
	ZonesByDensityWS zonesByDensityWS;

	@Autowired
	Mapper mapper;

	private static final Logger logger = LoggerFactory.getLogger(NumberOfPoiWS.class);

	@Override
	public void run(ApplicationArguments args) {
		if(args.getOptionNames().size() == 1) {
			if (args.containsOption(mapper.nbPOI)) { 
				POIRequest POIRequest = null;

				try {
					POIRequest = mapper.mapPOIRequestWithArgs(args);
				} catch (IOException e) {
					logger.error("IOException", e);
				}

				HttpEntity<POIRequest> entity = buildRestHttpEntity(POIRequest);
				numberOfPoiWS.callWS(entity);
			}
			else if(args.containsOption(mapper.densest)) {
				DensityRequest densityRequest = null;
				try {
					densityRequest = mapper.mapDensityRequestWithArgs(args);
				} catch (IOException e) {
					logger.error("IOException", e);
				}

				HttpEntity<DensityRequest> entity = buildRestHttpEntity(densityRequest);

				zonesByDensityWS.callWS(entity);
			}
		}
		else {
			logger.info("application must be call with 'npoi' or 'denset' arguments");
		}
	}

	private <T> HttpEntity<T> buildRestHttpEntity(T t) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return new HttpEntity<T>(t, headers);
	}

}
