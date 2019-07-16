package com.happn.techtest.dto.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.happn.techtest.dto.objects.ZoneDTO;

@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class ZonesResponse {

	private List<ZoneDTO> zones = new ArrayList<ZoneDTO>();

	public ZonesResponse(List<ZoneDTO> zones) {
		this.zones = zones;
	}
	
	public ZonesResponse() {}
	
	public List<ZoneDTO> getZones() {
		return zones;
	}

	public boolean contains(Object o) {
		return zones.contains(o);
	}


}
