package com.tta.broilers.entities.rest;

import java.util.Date;

public class WeightByBreed {


	
	private int breedID;
	private String description;
	private double weight;
	private Date visitDate;
	public int getBreedID() {
		return breedID;
	}
	public void setBreedID(int breedID) {
		this.breedID = breedID;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "WeightByBreed [breedID=" + breedID + ", description=" + description + ", weight=" + weight
				+ ", visitDate=" + visitDate + "]";
	}
	


	
	
	
	
	
	

	
	
	
}
