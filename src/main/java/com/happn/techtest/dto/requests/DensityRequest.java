package com.happn.techtest.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DensityRequest {

	@JsonProperty("n")
	private String density;

	@JsonCreator
	public DensityRequest(@JsonProperty("n") String density) {
		this.density = density;
	}

	public String getDensity() {
		return density;
	}

	public void setDensity(String density) {
		this.density = density;
	}

	@Override
	public String toString() {
		return "DensityRequest [density=" + density + "]";
	}

}
