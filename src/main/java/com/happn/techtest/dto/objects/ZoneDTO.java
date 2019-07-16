package com.happn.techtest.dto.objects;

import com.happn.techtest.serializers.SerializerWihtoutZeroPrecision;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ZoneDTO {
	
	@JsonProperty("minlat")
	@JsonSerialize(using = SerializerWihtoutZeroPrecision.class)
	private String minLat;
	
	@JsonProperty("maxlat")
	@JsonSerialize(using = SerializerWihtoutZeroPrecision.class)
	private String maxLat;
	
	@JsonProperty("minlon")
	@JsonSerialize(using = SerializerWihtoutZeroPrecision.class)
	private String minLon;
	
	@JsonProperty("maxlon")
	@JsonSerialize(using = SerializerWihtoutZeroPrecision.class)
	private String maxLon;
	
	@JsonCreator
	public ZoneDTO(@JsonProperty("minlat") String minLat, @JsonProperty("maxlat") String maxLat, 
			@JsonProperty("minlon") String minLon, @JsonProperty("maxlon") String maxLon) {
		this.minLat = minLat;
		this.maxLat = maxLat;
		this.minLon = minLon;
		this.maxLon = maxLon;
	}
	
	public ZoneDTO() {}

	public String getMinLat() {
		return minLat;
	}

	public void setMinLat(String minLat) {
		this.minLat = minLat;
	}

	public String getMaxLat() {
		return maxLat;
	}

	public void setMaxLat(String maxLat) {
		this.maxLat = maxLat;
	}

	public String getMinLon() {
		return minLon;
	}

	public void setMinLon(String minLon) {
		this.minLon = minLon;
	}

	public String getMaxLon() {
		return maxLon;
	}

	public void setMaxLon(String maxLon) {
		this.maxLon = maxLon;
	}

	@Override
	public String toString() {
		return "ZoneDTO [minLat=" + minLat + ", maxLat=" + maxLat + ", minLon=" + minLon + ", maxLon=" + maxLon + "]";
	}

}
