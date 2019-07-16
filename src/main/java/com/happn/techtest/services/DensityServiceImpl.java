package com.happn.techtest.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.happn.techtest.entities.Density;
import com.happn.techtest.entities.POIsOfFile;
import com.happn.techtest.entities.Zone;
import com.happn.techtest.options.Constants;

@Service
public class DensityServiceImpl implements DensityService {

	@Override
	public List<Zone> calculZonesByDensity(Density density) {
		ArrayList<Zone> zonesOfPOIs = new ArrayList<Zone>();
		fillZonesOfPOIs(zonesOfPOIs);
		LinkedHashMap<Zone, Integer> zonesFiltered  = calculZonesFilteredByZonesOfPOIs(zonesOfPOIs);
		LinkedHashMap<Zone, Integer> sortedMapByDensity = calculSortedMapDensityByZonesFiltered(zonesFiltered);
		List<Zone> arraySortedByDensity = new ArrayList<Zone>(sortedMapByDensity.keySet());
		List<Zone> result = arraySortedByDensity.subList(0, density.getDensity());

		return result;
	}

	private static Float roundToHalfMax(Float d) {
		return Math.round(d * 2 + Constants.SIZE_OF_ZONE) / 2.0f;
	}

	private static Float roundToHalfMin(Float d) {
		return Math.round(d * 2 - Constants.SIZE_OF_ZONE) / 2.0f;
	}

	private void fillZonesOfPOIs(ArrayList<Zone> zonesOfPOIs) {
		POIsOfFile.getEntrySet().forEach(entry -> {
			Float lat = entry.getValue().getLat();
			Float lon = entry.getValue().getLon();

			Zone zone = new Zone(roundToHalfMin(lat), roundToHalfMax(lat), roundToHalfMin(lon), roundToHalfMax(lon));
			zonesOfPOIs.add(zone);
		}); 
	}

	private LinkedHashMap<Zone, Integer> calculZonesFilteredByZonesOfPOIs(ArrayList<Zone> zonesOfPOIs){
		LinkedHashMap<Zone, Integer> zonesFiltered = new LinkedHashMap<Zone, Integer>();

		for (Zone currentZone : zonesOfPOIs) {
			POIsOfFile.getEntrySet().forEach(entry -> {
				Float lat = entry.getValue().getLat();
				Float lon = entry.getValue().getLon();

				if((lat >= currentZone.getMinLat() && lat <= currentZone.getMaxLat())
						&& (lon >= currentZone.getMinLon() && lon <= currentZone.getMaxLon())) {

					if(zonesFiltered.containsKey(currentZone)) {
						Integer count = zonesFiltered.get(currentZone);
						zonesFiltered.put(currentZone, (count == null) ? Constants.INCREMENT_DENSITY_VALUE : count + Constants.INCREMENT_DENSITY_VALUE);
					}
					else {
						zonesFiltered.put(currentZone, Constants.INCREMENT_DENSITY_VALUE);
					}
				}
			});
		}
		return zonesFiltered;
	}

	private LinkedHashMap<Zone, Integer> calculSortedMapDensityByZonesFiltered(LinkedHashMap<Zone, Integer> zonesFiltered){
		LinkedHashMap<Zone, Integer> sortedMapByDensity = new LinkedHashMap<>();

		zonesFiltered.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x -> sortedMapByDensity.put(x.getKey(), x.getValue()));

		return sortedMapByDensity;
	}
}