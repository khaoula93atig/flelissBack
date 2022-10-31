package com.tta.broilers.entities.rest;

import java.util.List;

public class FlockWeight {


	
	private List<Integer> ageFlock;
	private List<Double> weight;
	private String flockID;
	private String HouseID;
	private String centerID;
	
	
	
	public List<Integer> getAgeFlock() {
		return ageFlock;
	}
	public void setAgeFlock(List<Integer> ageFlock) {
		this.ageFlock = ageFlock;
	}
	public List<Double> getWeight() {
		return weight;
	}
	public void setWeight(List<Double> weight) {
		this.weight = weight;
	}
	public String getFlockID() {
		return flockID;
	}
	public void setFlockID(String flockID) {
		this.flockID = flockID;
	}
	public String getHouseID() {
		return HouseID;
	}
	public void setHouseID(String houseID) {
		HouseID = houseID;
	}
	public String getCenterID() {
		return centerID;
	}
	public void setCenterID(String centerID) {
		this.centerID = centerID;
	}
	@Override
	public String toString() {
		return "WeightByFlock [ageFlock=" + ageFlock + ", weight=" + weight + ", flockID=" + flockID + ", HouseID="
				+ HouseID + ", centerID=" + centerID + "]";
	}
	
	
	
	
	
}
