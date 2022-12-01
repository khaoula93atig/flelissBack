package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author EMNA
 *
 */
public class Flock {

	private String flockID;
	private String flockName;
	private String houseId;
	private String farmId;
	private int breed;
	private int cycle;
	private Date startOfCycle;

	private Date hatchDate;
	private int chikedPlaced;
	private String psOrigin;
	private House house;
	private Breed breedObject;
	private Date creationDate;
	private String hatchDateString;
	private String startOfCycleString;
	private int flockNumber;
	private boolean checkEndOfCycle;
	private Date endOfCycle;
	private int  restFlockNumber;
	
	
	public String getFarmId() {
		return farmId;
	}

	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}

	public int getChikedPlaced() {
		return chikedPlaced;
	}

	public void setChikedPlaced(int chikedPlaced) {
		this.chikedPlaced = chikedPlaced;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getFlockID() {
		return flockID;
	}

	public void setFlockID(String flockID) {
		this.flockID = flockID;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public int getBreed() {
		return breed;
	}

	public void setBreed(int breed) {
		this.breed = breed;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public Date getStartOfCycle() {
		return startOfCycle;
	}

	public void setStartOfCycle(Date startOfCycle) {
		this.startOfCycle = startOfCycle;
	}

	public Date getHatchDate() {
		return hatchDate;
	}

	public void setHatchDate(Date hatchDate) {
		this.hatchDate = hatchDate;
	}

	public String getPsOrigin() {
		return psOrigin;
	}

	public void setPsOrigin(String psOrigin) {
		this.psOrigin = psOrigin;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Breed getBreedObject() {
		return breedObject;
	}

	public void setBreedObject(Breed breedObject) {
		this.breedObject = breedObject;
	}

	public String getHatchDateString() {
		return hatchDateString;
	}

	public void setHatchDateString(String hatchDateString) {
		this.hatchDateString = hatchDateString;
	}

	public String getStartOfCycleString() {
		return startOfCycleString;
	}

	public void setStartOfCycleString(String startOfCycleString) {
		this.startOfCycleString = startOfCycleString;
	}

	public int getFlockNumber() {
		return flockNumber;
	}

	public void setFlockNumber(int flockNumber) {
		this.flockNumber = flockNumber;
	}



	public boolean isCheckEndOfCycle() {
		return checkEndOfCycle;
	}

	public void setCheckEndOfCycle(boolean checkEndOfCycle) {
		this.checkEndOfCycle = checkEndOfCycle;
	}

	public Date getEndOfCycle() {
		return endOfCycle;
	}

	public void setEndOfCycle(Date endOfCycle) {
		this.endOfCycle = endOfCycle;
	}

	public int getRestFlockNumber() {
		return restFlockNumber;
	}

	public void setRestFlockNumber(int restFlockNumber) {
		this.restFlockNumber = restFlockNumber;
	}
	

	public String getFlockName() {
		return flockName;
	}

	public void setFlockName(String flockName) {
		this.flockName = flockName;
	}

	@Override
	public String toString() {
		return "Flock [flockID=" + flockID + ", flockName=" + flockName + ", houseId=" + houseId + ", farmId=" + farmId
				+ ", breed=" + breed + ", cycle=" + cycle + ", startOfCycle=" + startOfCycle + ", hatchDate="
				+ hatchDate + ", chikedPlaced=" + chikedPlaced + ", psOrigin=" + psOrigin + ", house=" + house
				+ ", breedObject=" + breedObject + ", creationDate=" + creationDate + ", hatchDateString="
				+ hatchDateString + ", startOfCycleString=" + startOfCycleString + ", flockNumber=" + flockNumber
				+ ", checkEndOfCycle=" + checkEndOfCycle + ", endOfCycle=" + endOfCycle + ", restFlockNumber="
				+ restFlockNumber + "]";
	}

}
