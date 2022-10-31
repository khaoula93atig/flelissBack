package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */

public class Center {

	private String centerId;
	private int  housesNumber;
	private String centerName;
	private String address;
	private String breed;
	private String productionDensity;
	private String zone;
	private String centerManagerName;
	private String centerManagerEmail;
	private String centerManagerTel;
	private String nutritionSupervisor;
	private String sanitarySupervisor;
	private int bridsNumberPerHouse;
	private String centerMultiage;
	private double avMortalityPerFlock;
	private double avWaterConsumption;
	private double avFeedConsumption;
	private int eggProduction;
	private double avFcr;
	private double avEef;
	private String mainDiseases;
	private String species;
	private String farmId;
	private String companyId;
	private Date creationDate;
	private Company company;
	private Farm farm;
	
	
	
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public int getHousesNumber() {
		return housesNumber;
	}
	public void setHousesNumber(int housesNumber) {
		this.housesNumber = housesNumber;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getProductionDensity() {
		return productionDensity;
	}
	public void setProductionDensity(String productionDensity) {
		this.productionDensity = productionDensity;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getCenterManagerName() {
		return centerManagerName;
	}
	public void setCenterManagerName(String centerManagerName) {
		this.centerManagerName = centerManagerName;
	}
	public String getCenterManagerEmail() {
		return centerManagerEmail;
	}
	public void setCenterManagerEmail(String centerManagerEmail) {
		this.centerManagerEmail = centerManagerEmail;
	}
	public String getCenterManagerTel() {
		return centerManagerTel;
	}
	public void setCenterManagerTel(String centerManagerTel) {
		this.centerManagerTel = centerManagerTel;
	}
	public String getNutritionSupervisor() {
		return nutritionSupervisor;
	}
	public void setNutritionSupervisor(String nutritionSupervisor) {
		this.nutritionSupervisor = nutritionSupervisor;
	}
	public int getBridsNumberPerHouse() {
		return bridsNumberPerHouse;
	}
	public void setBridsNumberPerHouse(int bridsNumberPerHouse) {
		this.bridsNumberPerHouse = bridsNumberPerHouse;
	}
	public String getCenterMultiage() {
		return centerMultiage;
	}
	public void setCenterMultiage(String centerMultiage) {
		this.centerMultiage = centerMultiage;
	}
	public double getAvMortalityPerFlock() {
		return avMortalityPerFlock;
	}
	public void setAvMortalityPerFlock(double avMortalityPerFlock) {
		this.avMortalityPerFlock = avMortalityPerFlock;
	}
	public double getAvWaterConsumption() {
		return avWaterConsumption;
	}
	public void setAvWaterConsumption(double avWaterConsumption) {
		this.avWaterConsumption = avWaterConsumption;
	}
	public double getAvFeedConsumption() {
		return avFeedConsumption;
	}
	public void setAvFeedConsumption(double avFeedConsumption) {
		this.avFeedConsumption = avFeedConsumption;
	}
	public int getEggProduction() {
		return eggProduction;
	}
	public void setEggProduction(int eggProduction) {
		this.eggProduction = eggProduction;
	}
	public double getAvFcr() {
		return avFcr;
	}
	public void setAvFcr(double avFcr) {
		this.avFcr = avFcr;
	}
	public double getAvEef() {
		return avEef;
	}
	public void setAvEef(double avEef) {
		this.avEef = avEef;
	}
	public String getMainDiseases() {
		return mainDiseases;
	}
	public void setMainDiseases(String mainDiseases) {
		this.mainDiseases = mainDiseases;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getFarmId() {
		return farmId;
	}
	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	public String getSanitary_supervisor() {
		return sanitarySupervisor;
	}
	public void setSanitary_supervisor(String sanitary_supervisor) {
		this.sanitarySupervisor = sanitary_supervisor;
	}
	
	
	public String getSanitarySupervisor() {
		return sanitarySupervisor;
	}
	public void setSanitarySupervisor(String sanitarySupervisor) {
		this.sanitarySupervisor = sanitarySupervisor;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	@Override
	public String toString() {
		return "Center [centerId=" + centerId + ", housesNumber=" + housesNumber + ", centerName=" + centerName
				+ ", address=" + address + ", breed=" + breed + ", productionDensity=" + productionDensity + ", zone="
				+ zone + ", centerManagerName=" + centerManagerName + ", centerManagerEmail=" + centerManagerEmail
				+ ", centerManagerTel=" + centerManagerTel + ", nutritionSupervisor=" + nutritionSupervisor
				+ ", sanitarySupervisor=" + sanitarySupervisor + ", bridsNumberPerHouse=" + bridsNumberPerHouse
				+ ", centerMultiage=" + centerMultiage + ", avMortalityPerFlock=" + avMortalityPerFlock
				+ ", avWaterConsumption=" + avWaterConsumption + ", avFeedConsumption=" + avFeedConsumption
				+ ", eggProduction=" + eggProduction + ", avFcr=" + avFcr + ", avEef=" + avEef + ", mainDiseases="
				+ mainDiseases + ", species=" + species + ", farmId=" + farmId + ", companyId=" + companyId
				+ ", creationDate=" + creationDate + ", company=" + company + ", farm=" + farm + "]";
	}

	
	
	
}
