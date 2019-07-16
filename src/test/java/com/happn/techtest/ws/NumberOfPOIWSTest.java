package com.happn.techtest.ws;

import org.junit.Test;

import com.happn.techtest.config.ConfigTest;
import com.happn.techtest.dto.requests.POIRequest;
import com.happn.techtest.dto.responses.NumberPOIResponse;
import com.happn.techtest.helpers.NPOIJSONHelper;
import static com.jayway.restassured.RestAssured.given;


public class NumberOfPOIWSTest extends ConfigTest {

	@Test
	public void validRequestTest() throws InterruptedException {
		POIRequest POIRequest = NPOIJSONHelper.buildNPOIJSONRequest();
		NumberPOIResponse response = NPOIJSONHelper.buildNPOIJSONResponse();

		given().contentType("application/json").body(POIRequest)
		.when().post("/getNumberOfPoi")
		.then().extract().response().body().equals(response);
	}

	@Test
	public void badRequestTest() throws InterruptedException {
		given().contentType("application/json")
		.body("{bad content}")
		.when().post("/getNumberOfPoi").then().statusCode(BAD_REQUEST_CODE);
	}

	@Test
	public void notFoundRequestTest() throws InterruptedException {
		given().contentType("application/json")
		.body(NPOIJSONHelper.buildNPOIJsonDataWithTwoValueRequest())
		.when().post("/notFound").then().statusCode(NOT_FOUND_CODE);
	}
	
}
