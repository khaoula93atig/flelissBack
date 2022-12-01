package com.tta.broilers.entities.rest;

public class MortalityByBreed {
	private int breed;
	private double percentage;
	
	public int getBreed() {
		return breed;
	}
	public void setBreed(int breed) {
		this.breed = breed;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "MortalityByBreed [breed=" + breed + ", percentage=" + percentage + "]";
	}
	
	

	
}
