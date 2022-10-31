package com.tta.broilers.entities.rest;

public class WeeklyWeightForChart {
	 private int Week;
	private float averge;
	
	@Override
	public String toString() {
		return "WeeklyWeightForChart [Week=" + Week + ", averge=" + averge + "]";
	}
	
	public int getWeek() {
		return Week;
	}

	public void setWeek(int week) {
		Week = week;
	}

	public float getAverge() {
		return averge;
	}
	public void setAverge(float averge) {
		this.averge = averge;
	}
	

}
