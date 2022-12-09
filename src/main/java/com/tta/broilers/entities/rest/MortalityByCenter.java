package com.tta.broilers.entities.rest;

public class MortalityByCenter {
	private double percentage;
	private String centerId;
	
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	@Override
	public String toString() {
		return "MortalityByCenter [percentage=" + percentage + ", centerId=" + centerId + "]";
	}

}
