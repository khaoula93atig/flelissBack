package com.tta.broilers.entities;

import java.util.Date;


/**
 * @author rym lamouchi
 *
 */
public class House {

	private String houseId;
	private double area;
	private String ventilation; // static or dynamic
	private int density; // oiseaux/m²
	private int nbrCyclesPerYear; // nom de cycles par an
	private String feeder; // aliment sac or silot
	private String waterSource; // eau de pluie ou eau de réseau publique
	private int birdsNumber;
	
	private String farmID;
	private Farm farm;
	private Date creationDate;
	private int  durationOfRotation; //durée de la rotaion 
	
	private String centerId; 
	private String houseName; 
	
	public int getDurationOfRotation() {
		return durationOfRotation;
	}
	public void setDurationOfRotation(int durationOfRotation) {
		this.durationOfRotation = durationOfRotation;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getVentilation() {
		return ventilation;
	}
	public void setVentilation(String ventilation) {
		this.ventilation = ventilation;
	}
	public int getDensity() {
		return density;
	}
	public void setDensity(int density) {
		this.density = density;
	}
	public int getNbrCyclesPerYear() {
		return nbrCyclesPerYear;
	}
	public void setNbrCyclesPerYear(int nbrCyclesPerYear) {
		this.nbrCyclesPerYear = nbrCyclesPerYear;
	}
	public String getFeeder() {
		return feeder;
	}
	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}
	public String getWaterSource() {
		return waterSource;
	}
	public void setWaterSource(String waterSource) {
		this.waterSource = waterSource;
	}
	public int getBirdsNumber() {
		return birdsNumber;
	}
	public void setBirdsNumber(int birdsNumber) {
		this.birdsNumber = birdsNumber;
	}
	
	public String getFarmID() {
		return farmID;
	}
	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	@Override
	public String toString() {
		
		return "House [houseId=" + houseId + ", area=" + area + ", ventilation=" + ventilation + ", density=" + density
				+ ", nbrCyclesPerYear=" + nbrCyclesPerYear + ", feeder=" + feeder + ", waterSource=" + waterSource
				+ ", birdsNumber=" + birdsNumber + ", farmID=" + farmID + ", farm=" + farm + ", creationDate="
				+ creationDate + ", durationOfRotation=" + durationOfRotation + ", centerId=" + centerId
				+ ", houseName=" + houseName + "]";
		
		
		
	}

	
	
}
