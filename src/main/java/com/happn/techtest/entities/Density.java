package com.happn.techtest.entities;

public class Density {

	private Integer density;

	public Density(Integer density) {
		this.density = density;
	}
	
	public Density() {}

	public Integer getDensity() {
		return density;
	}

	public void setDensity(Integer density) {
		this.density = density;
	}
	
	@Override
	public String toString() {
		return "Density [density=" + density + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((density == null) ? 0 : density.hashCode());
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
		Density other = (Density) obj;
		if (density == null) {
			if (other.density != null)
				return false;
		} else if (!density.equals(other.density))
			return false;
		return true;
	}
	
}
