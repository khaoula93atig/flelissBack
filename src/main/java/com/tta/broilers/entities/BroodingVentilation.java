package com.tta.broilers.entities;

/**
 * @author rym lamouchi
 *
 */
public class BroodingVentilation {

	private  int min_birds_age;
	private  int max_birds_age;
	private double  meters_per_second  ;
	private double  min_meters_per_second  ;
	private double  max_meters_per_second  ;
	private int breed; 
	private int week;
	public int getMin_birds_age() {
		return min_birds_age;
	}
	public void setMin_birds_age(int min_birds_age) {
		this.min_birds_age = min_birds_age;
	}
	public int getMax_birds_age() {
		return max_birds_age;
	}
	public void setMax_birds_age(int max_birds_age) {
		this.max_birds_age = max_birds_age;
	}
	public double getMeters_per_second() {
		return meters_per_second;
	}
	public void setMeters_per_second(double meters_per_second) {
		this.meters_per_second = meters_per_second;
	}
	public double getMin_meters_per_second() {
		return min_meters_per_second;
	}
	public void setMin_meters_per_second(double min_meters_per_second) {
		this.min_meters_per_second = min_meters_per_second;
	}
	public double getMax_meters_per_second() {
		return max_meters_per_second;
	}
	public void setMax_meters_per_second(double max_meters_per_second) {
		this.max_meters_per_second = max_meters_per_second;
	}
	public int getBreed() {
		return breed;
	}
	public void setBreed(int breed) {
		this.breed = breed;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	@Override
	public String toString() {
		return "BroodingVentilation [min_birds_age=" + min_birds_age + ", max_birds_age=" + max_birds_age
				+ ", meters_per_second=" + meters_per_second + ", min_meters_per_second=" + min_meters_per_second
				+ ", max_meters_per_second=" + max_meters_per_second + ", breed=" + breed + ", week=" + week + "]";
	}

 
	
}
