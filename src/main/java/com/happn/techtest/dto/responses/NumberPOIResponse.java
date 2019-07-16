package com.happn.techtest.dto.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NumberPOIResponse {

	@JsonProperty("value")
	private String value;

	public NumberPOIResponse() {}

	@JsonCreator
	public NumberPOIResponse(@JsonProperty("value") String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ResponseNumberPOI [value=" + value + "]";
	}

}
