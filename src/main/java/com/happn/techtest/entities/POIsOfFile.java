package com.happn.techtest.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class POIsOfFile {

	private static final HashMap<String, POI> map = new HashMap<>();
    private static POIsOfFile INSTANCE = new POIsOfFile();
	
    private POIsOfFile() {}

    public static POIsOfFile getInstance() {
        return INSTANCE;
    }

    public static POI getValue(String key) {
        return map.get(key);
    }

    public static void add(String key, POI value) {
    	map.put(key, value);
    }
    
    public static Set<Map.Entry<String,POI>> getEntrySet() {
    	return map.entrySet();
    }
    
    public String toString() {
    	return map.toString();
    }
    
}
