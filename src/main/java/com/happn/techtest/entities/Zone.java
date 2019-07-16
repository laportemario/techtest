package com.happn.techtest.entities;


public class Zone {
	
	private float minLat;
	private float maxLat;
	private float minLon;
	private float maxLon;
	
	public Zone(float minLat, float maxLat, float minLon, float maxLon) {
		this.minLat = minLat;
		this.maxLat = maxLat;
		this.minLon = minLon;
		this.maxLon = maxLon;
	}
	
	public Zone() {}

	public float getMinLat() {
		return minLat;
	}

	public void setMinLat(float minLat) {
		this.minLat = minLat;
	}

	public float getMaxLat() {
		return maxLat;
	}

	public void setMaxLat(float maxLat) {
		this.maxLat = maxLat;
	}

	public float getMinLon() {
		return minLon;
	}

	public void setMinLon(float minLon) {
		this.minLon = minLon;
	}

	public float getMaxLon() {
		return maxLon;
	}

	public void setMaxLon(float maxLon) {
		this.maxLon = maxLon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(maxLat);
		result = prime * result + Float.floatToIntBits(maxLon);
		result = prime * result + Float.floatToIntBits(minLat);
		result = prime * result + Float.floatToIntBits(minLon);
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
		Zone other = (Zone) obj;
		if (Float.floatToIntBits(maxLat) != Float.floatToIntBits(other.maxLat))
			return false;
		if (Float.floatToIntBits(maxLon) != Float.floatToIntBits(other.maxLon))
			return false;
		if (Float.floatToIntBits(minLat) != Float.floatToIntBits(other.minLat))
			return false;
		if (Float.floatToIntBits(minLon) != Float.floatToIntBits(other.minLon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zone [minLat=" + minLat + ", maxLat=" + maxLat + ", minLon=" + minLon + ", maxLon=" + maxLon + "]";
	}

}
