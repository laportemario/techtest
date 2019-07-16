package com.happn.techtest.helpers;

import com.happn.techtest.dto.requests.POIRequest;
import com.happn.techtest.dto.responses.NumberPOIResponse;

public class NPOIJSONHelper {	
	static public String buildNPOIJsonDataWithTwoValueRequest() {
		return "{\"minlat\": 6.5, \"minlon\": -7}";
	}
		
	public static POIRequest buildNPOIJSONRequest() {
		return new POIRequest("6.5", "-7");
	}
	
	public static NumberPOIResponse buildNPOIJSONResponse() {
		return new NumberPOIResponse("2");
	}
}
