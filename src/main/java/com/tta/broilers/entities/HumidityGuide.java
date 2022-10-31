package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class HumidityGuide {

	private  int age_days;
	private int  min_relative_humidity  ;
	private int max_relative_humidity ;
	private int breed; 
	private Date creationDate;
	private int week;
	
	public int getAge_days() {
		return age_days;
	}
	public void setAge_days(int age_days) {
		this.age_days = age_days;
	}
	
	
	public int getMin_relative_humidity() {
		return min_relative_humidity;
	}
	public void setMin_relative_humidity(int min_relative_humidity) {
		this.min_relative_humidity = min_relative_humidity;
	}
	public int getMax_relative_humidity() {
		return max_relative_humidity;
	}
	public void setMax_relative_humidity(int max_relative_humidity) {
		this.max_relative_humidity = max_relative_humidity;
	}
	public int getBreed() {
		return breed;
	}
	public void setBreed(int breed) {
		this.breed = breed;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}

 
}
