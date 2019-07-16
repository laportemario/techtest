package com.happn.techtest.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class POIRequest {

	@JsonProperty("minlat")
	private String lat;

	@JsonProperty("minlon")
	private String lon;

	@JsonCreator
	public POIRequest(@JsonProperty("minlat") String lat, @JsonProperty("minlon") String lon) {
		this.lat = lat;
		this.lon = lon;
	}
	
	public POIRequest() {}

	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "POIRequest [lat=" + lat + ", lon=" + lon + "]";
	}

}
