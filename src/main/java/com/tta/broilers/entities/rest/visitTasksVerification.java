package com.tta.broilers.entities.rest;

import java.util.Date;

public class visitTasksVerification {
	private String visitId;
	private String flockID;
	private int age;
	private Double Measure;
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getFlockID() {
		return flockID;
	}
	public void setFlockID(String flockID) {
		this.flockID = flockID;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getMeasure() {
		return Measure;
	}
	public void setMeasure(Double measure) {
		Measure = measure;
	}
	@Override
	public String toString() {
		return "visitTasksVerification [visitId=" + visitId + ", flockID=" + flockID + ", age=" + age + ", Measure="
				+ Measure + "]";
	}
	
	

}
