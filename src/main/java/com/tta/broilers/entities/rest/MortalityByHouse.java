package com.tta.broilers.entities.rest;

public class MortalityByHouse {
	private double percentage;
	private String HouseId;
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getHouseId() {
		return HouseId;
	}
	public void setHouseId(String houseId) {
		HouseId = houseId;
	}
	@Override
	public String toString() {
		return "MortalityByHouse [percentage=" + percentage + ", HouseId=" + HouseId + "]";
	}
	
	

}
