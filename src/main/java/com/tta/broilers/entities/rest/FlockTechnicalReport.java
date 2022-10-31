package com.tta.broilers.entities.rest;

import java.util.Date;

import com.tta.broilers.entities.WeeklyFeed;

public  class FlockTechnicalReport {
	private String farmName;
	private double houseArea;
	private Date startOfCycle;
	private Date endOfCycle;
	private int flockNumber;
	private int cycle;
	private int restFlockNumber;
	private String centerName;
	private String breed;
	private String houseName;
	private double totalMortality ;
	private WeeklyFeed weeklyFeed;
	private double mortality1Week ;
	private double totalWeight ;
	private double totalFeedConsumption ;
	private double averageDailyGain ;
	private double fcr;
	private double pef ;
	
	
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public double getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(double houseArea) {
		this.houseArea = houseArea;
	}
	public Date getStartOfCycle() {
		return startOfCycle;
	}
	public void setStartOfCycle(Date startOfCycle) {
		this.startOfCycle = startOfCycle;
	}
	public Date getEndOfCycle() {
		return endOfCycle;
	}
	public void setEndOfCycle(Date endOfCycle) {
		this.endOfCycle = endOfCycle;
	}
	public int getFlockNumber() {
		return flockNumber;
	}
	public void setFlockNumber(int flockNumber) {
		this.flockNumber = flockNumber;
	}
	public int getCycle() {
		return cycle;
	}
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	public int getRestFlockNumber() {
		return restFlockNumber;
	}
	public void setRestFlockNumber(int restFlockNumber) {
		this.restFlockNumber = restFlockNumber;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public double getTotalMortality() {
		return totalMortality;
	}
	public void setTotalMortality(double totalMortality) {
		this.totalMortality = totalMortality;
	}
	public double getMortality1Week() {
		return mortality1Week;
	}
	public void setMortality1Week(double mortality1Week) {
		this.mortality1Week = mortality1Week;
	}
	public double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	public WeeklyFeed getWeeklyFeed() {
		return weeklyFeed;
	}
	public void setWeeklyFeed(WeeklyFeed weeklyFeed) {
		this.weeklyFeed = weeklyFeed;
	}
	public double getTotalFeedConsumption() {
		return totalFeedConsumption;
	}
	public void setTotalFeedConsumption(double totalFeedConsumption) {
		this.totalFeedConsumption = totalFeedConsumption;
	}
	public double getAverageDailyGain() {
		return averageDailyGain;
	}
	public void setAverageDailyGain(double averageDailyGain) {
		this.averageDailyGain = averageDailyGain;
	}
	public double getFcr() {
		return fcr;
	}
	public void setFcr(double fcr) {
		this.fcr = fcr;
	}
	public double getPef() {
		return pef;
	}
	public void setPef(double pef) {
		this.pef = pef;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	
	
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	@Override
	public String toString() {
		return "FlockTechnicalReport [farmName=" + farmName + ", houseArea=" + houseArea + ", startOfCycle="
				+ startOfCycle + ", endOfCycle=" + endOfCycle + ", flockNumber=" + flockNumber + ", cycle=" + cycle
				+ ", restFlockNumber=" + restFlockNumber + ", centerName=" + centerName + ", breed=" + breed
				+ ", houseName=" + houseName + ", totalMortality=" + totalMortality + ", weeklyFeed=" + weeklyFeed
				+ ", mortality1Week=" + mortality1Week + ", totalWeight=" + totalWeight + ", totalFeedConsumption="
				+ totalFeedConsumption + ", averageDailyGain=" + averageDailyGain + ", fcr=" + fcr + ", pef=" + pef
				+ "]";
	}


	

	
	
}
