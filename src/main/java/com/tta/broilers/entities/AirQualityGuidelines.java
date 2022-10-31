package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class AirQualityGuidelines {

	private  String element;
	private double  max_percentage  ;
	private double min_percentage ;
	private int breed; 
	private Date creationDate;
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public double getMax_percentage() {
		return max_percentage;
	}
	public void setMax_percentage(double max_percentage) {
		this.max_percentage = max_percentage;
	}
	public double getMin_percentage() {
		return min_percentage;
	}
	public void setMin_percentage(double min_percentage) {
		this.min_percentage = min_percentage;
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

 
}
