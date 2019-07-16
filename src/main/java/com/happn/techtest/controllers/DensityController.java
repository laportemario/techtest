package com.happn.techtest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.happn.techtest.dto.objects.ZoneDTO;
import com.happn.techtest.dto.requests.DensityRequest;
import com.happn.techtest.dto.responses.ZonesResponse;
import com.happn.techtest.entities.Density;
import com.happn.techtest.entities.Zone;
import com.happn.techtest.services.DensityService;

@Controller
public class DensityController {
    private DensityService densityService;

    @Autowired
    public DensityController(final DensityService densityService){
        this.densityService = densityService;
    }

    @PostMapping("/getZonesByDensity") 
    public ResponseEntity<ZonesResponse> getZonesByDensity(@RequestBody DensityRequest densityRequest) {
    	ModelMapper modelMapper = new ModelMapper();
    	Density density = modelMapper.map(densityRequest, Density.class);

    	List<Zone> zones = this.densityService.calculZonesByDensity(density);
    	List<ZoneDTO> zonesDTO = zones.stream()
    		        					.map(source -> modelMapper.map(source, ZoneDTO.class))
    		        					.collect(Collectors.toList());
    	
    
    	return new ResponseEntity<>(new ZonesResponse(zonesDTO), HttpStatus.OK);
    }
    
}