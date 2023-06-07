package com.tta.broilers.entities.rest;

public class FlockOutResult {
	private String farm;
	private String house;
	private String flock;
	private int age;
	private double weight;
	public String getFarm() {
		return farm;
	}
	public void setFarm(String farm) {
		this.farm = farm;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getFlock() {
		return flock;
	}
	public void setFlock(String flock) {
		this.flock = flock;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "FlockOutResult [farm=" + farm + ", house=" + house + ", flock=" + flock + ", weight="
				+ weight + "]";
	}
	
	

}
