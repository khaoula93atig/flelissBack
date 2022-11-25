package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author EMNA
 *
 */
//for weekly Measurement weight
public class WeeklyWeightMeasurement {

	private int breed;
	private String farmId;
	private double weight;
	private String centerId;
	private String houseId; 
	private String flockId;
	private int week;
	private int flockNbr;
	private Date creationDate;
	private double average;
	private double cv;
	private double uniformity;
	private double count;
	
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public double getCv() {
		return cv;
	}
	public void setCv(double cv) {
		this.cv = cv;
	}
	public double getUniformity() {
		return uniformity;
	}
	public void setUniformity(double uniformity) {
		this.uniformity = uniformity;
	}
	public int getBreed() {
		return breed;
	}
	public void setBreed(int breed) {
		this.breed = breed;
	}
	public String getFarmId() {
		return farmId;
	}
	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getFlockId() {
		return flockId;
	}
	public void setFlockId(String flockId) {
		this.flockId = flockId;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getFlockNbr() {
		return flockNbr;
	}
	public void setFlockNbr(int flockNbr) {
		this.flockNbr = flockNbr;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return "WeeklyWeightMeasurement [breed=" + breed + ", farmId=" + farmId + ", weight=" + weight + ", centerId="
				+ centerId + ", houseId=" + houseId + ", flockId=" + flockId + ", week=" + week + ", flockNbr="
				+ flockNbr + ", creationDate=" + creationDate + ", average=" + average + ", cv=" + cv + ", uniformity="
				+ uniformity + ", count=" + count + "]";
	}
	


	

}
