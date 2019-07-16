package com.happn.techtest.services;

import java.util.List;
import com.happn.techtest.entities.Density;
import com.happn.techtest.entities.Zone;


public interface DensityService {
	List<Zone>  calculZonesByDensity(Density density);
}