package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */

public class ChickReception {
	private Date visitDate;
	private int chicReceptionId;
	private String centerId;
	private String farmId;
	private Farm farm;
	private String  housesId;
	private String  flockId;
	private String breed;
	private Date hatchDate;
	private String chickPlaced;
	private String psOrigin;
	private int psAge;
	private String eyesClearBright;
	private String bodyDryWet;
	private String bodyTemp;
	private String crossBeaks;
	private String feetPropFormed;
	private String legsCleanRedHocks;
	
	private String signsGaspingHeavy;
	private String stringyNavels;
	private String blackButtons;
	private String navelsProperlyHealed;
	private String developedLegsSkin;
	private String thickFatBellies;
	
	private String largeAmountGrowth;
	private String fairlyEvenWingFeather;
	private String nonstressful;
	private Date creationDate;
	public int getChicReceptionId() {
		return chicReceptionId;
	}
	public void setChicReceptionId(int chicReceptionId) {
		this.chicReceptionId = chicReceptionId;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getFarmId() {
		return farmId;
	}
	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	public String getHousesId() {
		return housesId;
	}
	public void setHousesId(String housesId) {
		this.housesId = housesId;
	}
	public String getFlockId() {
		return flockId;
	}
	public void setFlockId(String flockId) {
		this.flockId = flockId;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Date getHatchDate() {
		return hatchDate;
	}
	public void setHatchDate(Date hatchDate) {
		this.hatchDate = hatchDate;
	}
	public String getChickPlaced() {
		return chickPlaced;
	}
	public void setChickPlaced(String chickPlaced) {
		this.chickPlaced = chickPlaced;
	}
	public String getPsOrigin() {
		return psOrigin;
	}
	public void setPsOrigin(String psOrigin) {
		this.psOrigin = psOrigin;
	}
	public int getPsAge() {
		return psAge;
	}
	public void setPsAge(int psAge) {
		this.psAge = psAge;
	}
	public String getEyesClearBright() {
		return eyesClearBright;
	}
	public void setEyesClearBright(String eyesClearBright) {
		this.eyesClearBright = eyesClearBright;
	}
	public String getBodyDryWet() {
		return bodyDryWet;
	}
	public void setBodyDryWet(String bodyDryWet) {
		this.bodyDryWet = bodyDryWet;
	}
	public String getBodyTemp() {
		return bodyTemp;
	}
	public void setBodyTemp(String bodyTemp) {
		this.bodyTemp = bodyTemp;
	}
	public String getCrossBeaks() {
		return crossBeaks;
	}
	public void setCrossBeaks(String crossBeaks) {
		this.crossBeaks = crossBeaks;
	}
	public String getFeetPropFormed() {
		return feetPropFormed;
	}
	public void setFeetPropFormed(String feetPropFormed) {
		this.feetPropFormed = feetPropFormed;
	}
	public String getLegsCleanRedHocks() {
		return legsCleanRedHocks;
	}
	public void setLegsCleanRedHocks(String legsCleanRedHocks) {
		this.legsCleanRedHocks = legsCleanRedHocks;
	}
	public String getSignsGaspingHeavy() {
		return signsGaspingHeavy;
	}
	public void setSignsGaspingHeavy(String signsGaspingHeavy) {
		this.signsGaspingHeavy = signsGaspingHeavy;
	}
	public String getStringyNavels() {
		return stringyNavels;
	}
	public void setStringyNavels(String stringyNavels) {
		this.stringyNavels = stringyNavels;
	}
	public String getBlackButtons() {
		return blackButtons;
	}
	public void setBlackButtons(String blackButtons) {
		this.blackButtons = blackButtons;
	}
	public String getNavelsProperlyHealed() {
		return navelsProperlyHealed;
	}
	public void setNavelsProperlyHealed(String navelsProperlyHealed) {
		this.navelsProperlyHealed = navelsProperlyHealed;
	}
	public String getDevelopedLegsSkin() {
		return developedLegsSkin;
	}
	public void setDevelopedLegsSkin(String developedLegsSkin) {
		this.developedLegsSkin = developedLegsSkin;
	}
	public String getThickFatBellies() {
		return thickFatBellies;
	}
	public void setThickFatBellies(String thickFatBellies) {
		this.thickFatBellies = thickFatBellies;
	}
	public String getLargeAmountGrowth() {
		return largeAmountGrowth;
	}
	public void setLargeAmountGrowth(String largeAmountGrowth) {
		this.largeAmountGrowth = largeAmountGrowth;
	}
	public String getFairlyEvenWingFeather() {
		return fairlyEvenWingFeather;
	}
	public void setFairlyEvenWingFeather(String fairlyEvenWingFeather) {
		this.fairlyEvenWingFeather = fairlyEvenWingFeather;
	}
	public String getNonstressful() {
		return nonstressful;
	}
	public void setNonstressful(String nonstressful) {
		this.nonstressful = nonstressful;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	@Override
	public String toString() {
		return "ChickReception [visitDate=" + visitDate + ", chicReceptionId=" + chicReceptionId + ", centerId="
				+ centerId + ", farmId=" + farmId + ", farm=" + farm + ", housesId=" + housesId + ", flockId=" + flockId
				+ ", breed=" + breed + ", hatchDate=" + hatchDate + ", chickPlaced=" + chickPlaced + ", psOrigin="
				+ psOrigin + ", psAge=" + psAge + ", eyesClearBright=" + eyesClearBright + ", bodyDryWet=" + bodyDryWet
				+ ", bodyTemp=" + bodyTemp + ", crossBeaks=" + crossBeaks + ", feetPropFormed=" + feetPropFormed
				+ ", legsCleanRedHocks=" + legsCleanRedHocks + ", signsGaspingHeavy=" + signsGaspingHeavy
				+ ", stringyNavels=" + stringyNavels + ", blackButtons=" + blackButtons + ", navelsProperlyHealed="
				+ navelsProperlyHealed + ", developedLegsSkin=" + developedLegsSkin + ", thickFatBellies="
				+ thickFatBellies + ", largeAmountGrowth=" + largeAmountGrowth + ", fairlyEvenWingFeather="
				+ fairlyEvenWingFeather + ", nonstressful=" + nonstressful + ", creationDate=" + creationDate + "]";
	}
	
	
	
	
}
