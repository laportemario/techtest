package com.happn.techtest.serializers;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SerializerWihtoutZeroPrecision extends JsonSerializer<String> {
	@Override
	public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
	JsonProcessingException {
		DecimalFormat decimalFormat = new DecimalFormat("0.#");
		String result = decimalFormat.format(Double.valueOf(value)).replace(",",".");
		jgen.writeString(result); 
	}

}