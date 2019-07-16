package com.happn.techtest.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class POI {

	@JsonProperty("minlat")
	private float lat;
	@JsonProperty("minlon")
	private float lon;

	@JsonCreator
	public POI(@JsonProperty("minlat") float lat, @JsonProperty("minlon") float lon) {
		this.lat = lat;
		this.lon = lon;
	}
	
	public POI() {}

	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Poi [lat=" + lat + ", lon=" + lon + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(lat);
		result = prime * result + Float.floatToIntBits(lon);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		POI other = (POI) obj;
		if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
			return false;
		if (Float.floatToIntBits(lon) != Float.floatToIntBits(other.lon))
			return false;
		return true;
	}

}
