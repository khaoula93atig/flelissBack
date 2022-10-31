package com.tta.broilers.entities.rest;

import java.util.Date;

public class WeightVariation {

	private double weightVariationFCR;
	private double weightVariationDWG;
	private double lastWeightMeasure;
	
	private int ageFlock;
	private Date endingDate;
	private Date beginningDate;
    private int endingDay;
    private int PrevDay;
    
	public double getWeightVariationFCR() {
		return weightVariationFCR;
	}
	public void setWeightVariationFCR(double weightVariationFCR) {
		this.weightVariationFCR = weightVariationFCR;
	}
	public double getWeightVariationDWG() {
		return weightVariationDWG;
	}
	public void setWeightVariationDWG(double weightVariationDWG) {
		this.weightVariationDWG = weightVariationDWG;
	}
	public int getAgeFlock() {
		return ageFlock;
	}
	public void setAgeFlock(int ageFlock) {
		this.ageFlock = ageFlock;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public Date getBeginningDate() {
		return beginningDate;
	}
	public void setBeginningDate(Date beginningDate) {
		this.beginningDate = beginningDate;
	}
	public int getEndingDay() {
		return endingDay;
	}
	public void setEndingDay(int endingDay) {
		this.endingDay = endingDay;
	}
	public int getPrevDay() {
		return PrevDay;
	}
	public void setPrevDay(int prevDay) {
		PrevDay = prevDay;
	}
	public double getLastWeightMeasure() {
		return lastWeightMeasure;
	}
	public void setLastWeightMeasure(double lastWeightMeasure) {
		this.lastWeightMeasure = lastWeightMeasure;
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}
