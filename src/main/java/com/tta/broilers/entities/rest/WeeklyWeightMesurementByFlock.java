package com.tta.broilers.entities.rest;

public class WeeklyWeightMesurementByFlock {
	private int week;
	private String flockId;
	private double average;
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getFlockId() {
		return flockId;
	}
	public void setFlockId(String flockId) {
		this.flockId = flockId;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return "WeeklyWeightMeurementByFlock [week=" + week + ", flockId=" + flockId + ", average=" + average + "]";
	}
	

}
