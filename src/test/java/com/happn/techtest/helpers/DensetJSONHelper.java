package com.happn.techtest.helpers;

import java.util.ArrayList;
import java.util.List;

import com.happn.techtest.dto.objects.ZoneDTO;
import com.happn.techtest.dto.requests.DensityRequest;
import com.happn.techtest.dto.responses.ZonesResponse;

public class DensetJSONHelper {

	static public String buildDensetJSONWithNequalTwoRequest() {
		return "{\"n\": \"2\"}";
	}
	
	
	public static DensityRequest buildDensetJSONRequest() {
		return new DensityRequest("2");
	}

	public static ZonesResponse buildDensetJSONResponse(){		
		ZoneDTO zoneDTO = new ZoneDTO("-2.5", "-2", "38", "38.5");
		ZoneDTO zoneDTO2 = new ZoneDTO("6.5", "7", "-7", "-6.5");

		List<ZoneDTO> zones = new ArrayList<ZoneDTO>();

		zones.add(zoneDTO);
		zones.add(zoneDTO2);

		ZonesResponse response = new ZonesResponse(zones);

		return response;
	}

}
