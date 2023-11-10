package com.tta.broilers.entities.rest;

public class MortalityByFarm {
	private double percentage ;
	private String farmName;
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmId) {
		this.farmName = farmId;
	}
	@Override
	public String toString() {
		return "MortalityByFarm [percentage=" + percentage + ", farmId=" + farmName + "]";
	}

}
