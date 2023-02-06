package com.tta.broilers.entities.rest;

public class MortalityByFlock {
	private double percentage;
	private String flockName;
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getFlockName() {
		return flockName;
	}
	public void setFlockName(String flockName) {
		this.flockName = flockName;
	}
	@Override
	public String toString() {
		return "MortalityByFlock [percentage=" + percentage + ", flockName=" + flockName + "]";
	}
	
	

}
