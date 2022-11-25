package com.tta.broilers.entities.rest;

public class MortalityByFarm {
	private double percentage ;
	private String farmId;
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getFarmId() {
		return farmId;
	}
	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}
	@Override
	public String toString() {
		return "MortalityByFarm [percentage=" + percentage + ", farmId=" + farmId + "]";
	}

}
