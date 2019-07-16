package com.happn.techtest.services;

import org.springframework.stereotype.Service;

import com.happn.techtest.entities.POI;
import com.happn.techtest.entities.POIsOfFile;
import com.happn.techtest.options.Constants;

@Service
public class POIServiceImpl implements POIService {
	Integer result;

	public POIServiceImpl() {
		result = 0;
	}

	@Override
	public String calculNumberOfPOIs(POI poi) {
		Float currentLat = poi.getLat();
		Float currentLon = poi.getLon();

		POIsOfFile.getEntrySet().forEach(entry -> {
			Float lat = entry.getValue().getLat();
			Float lon = entry.getValue().getLon();

			if((Math.abs(lat - currentLat) >= 0 && Math.abs(lat - currentLat) <= Constants.SIZE_OF_ZONE)
					&& (Math.abs(lon - currentLon) >= 0 && Math.abs(lon - currentLon) <= Constants.SIZE_OF_ZONE)) {
				result++;
			}
		}); 
		
		return String.valueOf(result);
	}

}
