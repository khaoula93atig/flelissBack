package com.tta.broilers.entities.rest;


public class WeightByFlock {


	
	private int ageFlock;
	private double weight;
	private String flockID;
	private String HouseID;
	private String centerID;
	
	public int getAgeFlock() {
		return ageFlock;
	}
	public void setAgeFlock(int ageFlock) {
		this.ageFlock = ageFlock;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
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
