package com.happn.techtest.ws;

import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;

import com.happn.techtest.config.ConfigTest;
import com.happn.techtest.dto.requests.DensityRequest;
import com.happn.techtest.dto.responses.ZonesResponse;
import com.happn.techtest.helpers.DensetJSONHelper;

public class ZonesByDensityWSTest extends ConfigTest {

	@Test
	public void validRequestTest() throws InterruptedException {		
		DensityRequest densityRequest = DensetJSONHelper.buildDensetJSONRequest();
		ZonesResponse zonesResponse = DensetJSONHelper.buildDensetJSONResponse();

		given().contentType("application/json").body(densityRequest)
		.when().post("/getZonesByDensity")
		.then().extract().response().body().equals(zonesResponse);
	}

	@Test
	public void badRequestTest() throws InterruptedException {
		given().contentType("application/json")
		.body("{bad content}")
		.when().post("/getZonesByDensity").then().statusCode(BAD_REQUEST_CODE);
	}

	@Test
	public void notFoundRequestTest() throws InterruptedException {
		given().contentType("application/json")
		.body(DensetJSONHelper.buildDensetJSONWithNequalTwoRequest())
		.when().post("/notFound").then().statusCode(NOT_FOUND_CODE);
	}


}