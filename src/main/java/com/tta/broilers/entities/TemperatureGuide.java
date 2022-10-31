package com.tta.broilers.entities;

/**
 * @author rym lamouchi
 *
 */
public class TemperatureGuide {

	private  int age_days;
	private double  lower_30_weeks  ;
	private double upper_30_weeks ;
	private int breed; 
	private int week;
	public int getAge_days() {
		return age_days;
	}
	public void setAge_days(int age_days) {
		this.age_days = age_days;
	}
	public double getLower_30_weeks() {
		return lower_30_weeks;
	}
	public void setLower_30_weeks(double lower_30_weeks) {
		this.lower_30_weeks = lower_30_weeks;
	}
	public double getUpper_30_weeks() {
		return upper_30_weeks;
	}
	public void setUpper_30_weeks(double upper_30_weeks) {
		this.upper_30_weeks = upper_30_weeks;
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
		return "TemperatureGuide [age_days=" + age_days + ", lower_30_weeks=" + lower_30_weeks + ", upper_30_weeks="
				+ upper_30_weeks + ", breed=" + breed  + ", week=" + week + "]";
	}

	
 
}
