package com.tta.broilers.entities;

import java.util.Date;

public class Visit {

	private String visitId;
	private Date visitDate;
	private String frequency; // daily / weekly
	private String farmId;
	private String flockID;
	private String houseID;
	private String username;
	private Flock flock;
	private User user;
	private int ageFlock;
	private Date creationDate;
	private String visitdateString;
	private double morbidity;
	private double mortality;
	private double dwg;
	private double eep;
	private double total_water_consumption;
	private double total_feed_consumption;
	private double fcr;
	private String  typeVisit;
	private String statusSave;
	private String centerID;
	
	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFlockID() {
		return flockID;
	}

	public void setFlockID(String flockID) {
		this.flockID = flockID;
	}

 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAgeFlock() {
		return ageFlock;
	}

	public void setAgeFlock(int ageFlock) {
		this.ageFlock = ageFlock;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Flock getFlock() {
		return flock;
	}

	public void setFlock(Flock flock) {
		this.flock = flock;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHouseID() {
		return houseID;
	}

	public void setHouseID(String houseID) {
		this.houseID = houseID;
	}

	public String getVisitdateString() {
		return visitdateString;
	}

	public void setVisitdateString(String visitdateString) {
		this.visitdateString = visitdateString;
	}

	public double getMorbidity() {
		return morbidity;
	}

	public void setMorbidity(double morbidity) {
		this.morbidity = morbidity;
	}

	public double getMortality() {
		return mortality;
	}

	public void setMortality(double mortality) {
		this.mortality = mortality;
	}

	public double getDwg() {
		return dwg;
	}

	public void setDwg(double dwg) {
		this.dwg = dwg;
	}

	public double getEep() {
		return eep;
	}

	public void setEep(double eep) {
		this.eep = eep;
	}

	public double getTotal_water_consumption() {
		return total_water_consumption;
	}

	public void setTotal_water_consumption(double total_water_consumption) {
		this.total_water_consumption = total_water_consumption;
	}

	public double getTotal_feed_consumption() {
		return total_feed_consumption;
	}

	public void setTotal_feed_consumption(double total_feed_consumption) {
		this.total_feed_consumption = total_feed_consumption;
	}

	public double getFcr() {
		return fcr;
	}

	public void setFcr(double fcr) {
		this.fcr = fcr;
	}
	public String getTypeVisit() {
		return typeVisit;
	}

	public void setTypeVisit(String typeVisit) {
		this.typeVisit = typeVisit;
	}


	public String getStatusSave() {
		return statusSave;
	}

	public void setStatusSave(String statusSave) {
		this.statusSave = statusSave;
	}
	

	public String getFarmId() {
		return farmId;
	}

	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}

	public String getCenterID() {
		return centerID;
	}

	public void setCenterID(String centerID) {
		this.centerID = centerID;
	}

	@Override
	public String toString() {
		return "Visit [visitId=" + visitId + ", visitDate=" + visitDate + ", frequency=" + frequency + ", flockID="
				+ flockID + ", houseID=" + houseID + ", username=" + username + ", flock=" + flock + ", user=" + user
				+ ", ageFlock=" + ageFlock + ", creationDate=" + creationDate + ", visitdateString=" + visitdateString
				+ ", morbidity=" + morbidity + ", mortality=" + mortality + ", dwg=" + dwg + ", eep=" + eep
				+ ", total_water_consumption=" + total_water_consumption + ", total_feed_consumption="
				+ total_feed_consumption + ", fcr=" + fcr + ", typeVisit=" + typeVisit + ", statusSave=" + statusSave
				+ "]";
	}

	
}
