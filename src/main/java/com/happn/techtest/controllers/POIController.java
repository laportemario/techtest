package com.happn.techtest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.happn.techtest.dto.requests.POIRequest;
import com.happn.techtest.dto.responses.NumberPOIResponse;
import com.happn.techtest.entities.POI;
import com.happn.techtest.services.POIService;

@Controller
public class POIController {
	
    private POIService poiService;

    @Autowired
    public POIController(final POIService poiService){
        this.poiService = poiService;
    }

    @PostMapping("/getNumberOfPoi") 
    public ResponseEntity<NumberPOIResponse> getNumberOfPoi(@RequestBody POIRequest nbpoi) {    	
    	ModelMapper modelMapper = new ModelMapper();
    	POI poi = modelMapper.map(nbpoi, POI.class);
    	String result = this.poiService.calculNumberOfPOIs(poi);
    	
    	return new ResponseEntity<>(new NumberPOIResponse(result), HttpStatus.OK);
    }
    
    
	
}