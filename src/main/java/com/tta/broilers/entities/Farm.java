package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author EMNA
 *
 */

public class Farm {

	private String farmId;
	private String farmName;
	private int housesNumber;
	private String address;
	private String area;
	private String breed;  //  Hubbard,   Cobb 500 ,  Ross  ,  Arbor Acres plus
	private String typeProduction; // Broilers     Pullets   Laying hens   breeders
	private String farmManageName = "";
	private String farmManageEmail = "";
	private String farmManageTel = "";
	private String companyID;
	private Company company;
	private int bridsNumberPerCenter;
	private int numberCenter;
	private String result;
	private double avMortalityRate;
	private double fcr;
	private double epef;
	private double avLayRate;
	private int rotation;
	
	
	
	private Date creationDate;
	
	
	
	
	
	public String getFarmId() {
		return farmId;
	}
	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public int getHousesNumber() {
		return housesNumber;
	}
	public void setHousesNumber(int housesNumber) {
		this.housesNumber = housesNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getTypeProduction() {
		return typeProduction;
	}
	public void setTypeProduction(String type_production) {
		this.typeProduction = type_production;
	}
	public String getFarmManageName() {
		return farmManageName;
	}
	public void setFarmManageName(String farmManageName) {
		this.farmManageName = farmManageName;
	}
	public String getFarmManageEmail() {
		return farmManageEmail;
	}
	public void setFarmManageEmail(String farmManageEmail) {
		this.farmManageEmail = farmManageEmail;
	}
	public String getFarmManageTel() {
		return farmManageTel;
	}
	public void setFarmManageTel(String farmManageTel) {
		this.farmManageTel = farmManageTel;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getBridsNumberPerCenter() {
		return bridsNumberPerCenter;
	}
	public void setBridsNumberPerCenter(int bridsNumberPerCenter) {
		this.bridsNumberPerCenter = bridsNumberPerCenter;
	}
	public int getNumberCenter() {
		return numberCenter;
	}
	public void setNumberCenter(int numberCenter) {
		this.numberCenter = numberCenter;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public double getAvMortalityRate() {
		return avMortalityRate;
	}
	public void setAvMortalityRate(double avMortalityRate) {
		this.avMortalityRate = avMortalityRate;
	}
	public double getFcr() {
		return fcr;
	}
	public void setFcr(double fcr) {
		this.fcr = fcr;
	}
	public double getEpef() {
		return epef;
	}
	public void setEpef(double epef) {
		this.epef = epef;
	}
	public double getAvLayRate() {
		return avLayRate;
	}
	public void setAvLayRate(double avLayRate) {
		this.avLayRate = avLayRate;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	@Override
	public String toString() {
		return "Farm [farmId=" + farmId + ", farmName=" + farmName + ", housesNumber=" + housesNumber + ", address="
				+ address + ", area=" + area + ", breed=" + breed + ", typeProduction=" + typeProduction
				+ ", farmManageName=" + farmManageName + ", farmManageEmail=" + farmManageEmail + ", farmManageTel="
				+ farmManageTel + ", companyID=" + companyID + ", company=" + company + ", bridsNumberPerCenter="
				+ bridsNumberPerCenter + ", numberCenter=" + numberCenter + ", result=" + result + ", avMortalityRate="
				+ avMortalityRate + ", fcr=" + fcr + ", epef=" + epef + ", avLayRate=" + avLayRate + ", rotation="
				+ rotation + ", creationDate=" + creationDate + "]";
	}


	
	
	

}
