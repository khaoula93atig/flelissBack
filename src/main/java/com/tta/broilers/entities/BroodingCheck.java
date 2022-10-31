package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */

public class BroodingCheck {
	private String broodingCheckId;
	private String litterDepth;
	private Farm farm;
	private String  farmId;
	private String  housesId;
	private String  centerID;
	private String temperature ;
	private String preHeatLeast;
	private String airTemperature ;
	private String realtiveHumidity ;
	private String airSpeed ;
	private String positionSuppDrink ;
	private String deliveryVehiTemp ;
	private String deliveryVehiHumi ;
	private String deliveryVehicleHygiene;
	private String chickConfort ;
	private String externalEnvCond ;
	private String transitTime ;
	private String deliveryVehicleAirExch ;
	private String internalChickTemp;
	private String weighSampleChick  ;
	
	private String placeChicksQuickly;
	private String ensureFeedWater;
	private String lightIntensity;
	private String checkChickBehavior;
	private String checkChickWaterSupply;
	private String checkFeedSupply;
	private String checkChickCropFill;
	private String distributionDayOldChicks;
	private String dailyPurgesPiping;
	private String airQuality;
	private Date creationDate;
	private String username;
	
	public String getBroodingCheckId() {
		return broodingCheckId;
	}
	public void setBroodingCheckId(String broodingCheckId) {
		this.broodingCheckId = broodingCheckId;
	}
	public String getLitterDepth() {
		return litterDepth;
	}
	public void setLitterDepth(String litterDepth) {
		this.litterDepth = litterDepth;
	}
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	public String getFarmId() {
		return farmId;
	}
	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}
	public String getHousesId() {
		return housesId;
	}
	public void setHousesId(String housesId) {
		this.housesId = housesId;
	}
	public String getCenterID() {
		return centerID;
	}
	public void setCenterID(String centerID) {
		this.centerID = centerID;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPreHeatLeast() {
		return preHeatLeast;
	}
	public void setPreHeatLeast(String preHeatLeast) {
		this.preHeatLeast = preHeatLeast;
	}
	public String getAirTemperature() {
		return airTemperature;
	}
	public void setAirTemperature(String airTemperature) {
		this.airTemperature = airTemperature;
	}
	public String getRealtiveHumidity() {
		return realtiveHumidity;
	}
	public void setRealtiveHumidity(String realtiveHumidity) {
		this.realtiveHumidity = realtiveHumidity;
	}
	public String getAirSpeed() {
		return airSpeed;
	}
	public void setAirSpeed(String airSpeed) {
		this.airSpeed = airSpeed;
	}
	public String getPositionSuppDrink() {
		return positionSuppDrink;
	}
	public void setPositionSuppDrink(String positionSuppDrink) {
		this.positionSuppDrink = positionSuppDrink;
	}
	public String getDeliveryVehiTemp() {
		return deliveryVehiTemp;
	}
	public void setDeliveryVehiTemp(String deliveryVehiTemp) {
		this.deliveryVehiTemp = deliveryVehiTemp;
	}
	public String getDeliveryVehiHumi() {
		return deliveryVehiHumi;
	}
	public void setDeliveryVehiHumi(String deliveryVehiHumi) {
		this.deliveryVehiHumi = deliveryVehiHumi;
	}
	public String getChickConfort() {
		return chickConfort;
	}
	public void setChickConfort(String chickConfort) {
		this.chickConfort = chickConfort;
	}
	public String getExternalEnvCond() {
		return externalEnvCond;
	}
	public void setExternalEnvCond(String externalEnvCond) {
		this.externalEnvCond = externalEnvCond;
	}
	public String getTransitTime() {
		return transitTime;
	}
	public void setTransitTime(String transitTime) {
		this.transitTime = transitTime;
	}
	public String getDeliveryVehicleAirExch() {
		return deliveryVehicleAirExch;
	}
	public void setDeliveryVehicleAirExch(String deliveryVehicleAirExch) {
		this.deliveryVehicleAirExch = deliveryVehicleAirExch;
	}
	public String getInternalChickTemp() {
		return internalChickTemp;
	}
	public void setInternalChickTemp(String internalChickTemp) {
		this.internalChickTemp = internalChickTemp;
	}
	public String getWeighSampleChick() {
		return weighSampleChick;
	}
	public void setWeighSampleChick(String weighSampleChick) {
		this.weighSampleChick = weighSampleChick;
	}
	public String getPlaceChicksQuickly() {
		return placeChicksQuickly;
	}
	public void setPlaceChicksQuickly(String placeChicksQuickly) {
		this.placeChicksQuickly = placeChicksQuickly;
	}
	public String getEnsureFeedWater() {
		return ensureFeedWater;
	}
	public void setEnsureFeedWater(String ensureFeedWater) {
		this.ensureFeedWater = ensureFeedWater;
	}
	public String getLightIntensity() {
		return lightIntensity;
	}
	public void setLightIntensity(String lightIntensity) {
		this.lightIntensity = lightIntensity;
	}
	public String getCheckChickBehavior() {
		return checkChickBehavior;
	}
	public void setCheckChickBehavior(String checkChickBehavior) {
		this.checkChickBehavior = checkChickBehavior;
	}
	public String getCheckChickWaterSupply() {
		return checkChickWaterSupply;
	}
	public void setCheckChickWaterSupply(String checkChickWaterSupply) {
		this.checkChickWaterSupply = checkChickWaterSupply;
	}
	public String getCheckFeedSupply() {
		return checkFeedSupply;
	}
	public void setCheckFeedSupply(String checkFeedSupply) {
		this.checkFeedSupply = checkFeedSupply;
	}
	public String getCheckChickCropFill() {
		return checkChickCropFill;
	}
	public void setCheckChickCropFill(String checkChickCropFill) {
		this.checkChickCropFill = checkChickCropFill;
	}
	public String getDistributionDayOldChicks() {
		return distributionDayOldChicks;
	}
	public void setDistributionDayOldChicks(String distributionDayOldChicks) {
		this.distributionDayOldChicks = distributionDayOldChicks;
	}
	public String getDailyPurgesPiping() {
		return dailyPurgesPiping;
	}
	public void setDailyPurgesPiping(String dailyPurgesPiping) {
		this.dailyPurgesPiping = dailyPurgesPiping;
	}
	public String getAirQuality() {
		return airQuality;
	}
	public void setAirQuality(String airQuality) {
		this.airQuality = airQuality;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDeliveryVehicleHygiene() {
		return deliveryVehicleHygiene;
	}
	public void setDeliveryVehicleHygiene(String deliveryVehicleHygiene) {
		this.deliveryVehicleHygiene = deliveryVehicleHygiene;
	}
	@Override
	public String toString() {
		return "BroodingCheck [broodingCheckId=" + broodingCheckId + ", litterDepth=" + litterDepth + ", farm=" + farm
				+ ", farmId=" + farmId + ", housesId=" + housesId + ", centerID=" + centerID + ", temperature="
				+ temperature + ", preHeatLeast=" + preHeatLeast + ", airTemperature=" + airTemperature
				+ ", realtiveHumidity=" + realtiveHumidity + ", airSpeed=" + airSpeed + ", positionSuppDrink="
				+ positionSuppDrink + ", deliveryVehiTemp=" + deliveryVehiTemp + ", deliveryVehiHumi="
				+ deliveryVehiHumi + ", deliveryVehicleHygiene=" + deliveryVehicleHygiene + ", chickConfort="
				+ chickConfort + ", externalEnvCond=" + externalEnvCond + ", transitTime=" + transitTime
				+ ", deliveryVehicleAirExch=" + deliveryVehicleAirExch + ", internalChickTemp=" + internalChickTemp
				+ ", weighSampleChick=" + weighSampleChick + ", placeChicksQuickly=" + placeChicksQuickly
				+ ", ensureFeedWater=" + ensureFeedWater + ", lightIntensity=" + lightIntensity
				+ ", checkChickBehavior=" + checkChickBehavior + ", checkChickWaterSupply=" + checkChickWaterSupply
				+ ", checkFeedSupply=" + checkFeedSupply + ", checkChickCropFill=" + checkChickCropFill
				+ ", distributionDayOldChicks=" + distributionDayOldChicks + ", dailyPurgesPiping=" + dailyPurgesPiping
				+ ", airQuality=" + airQuality + ", creationDate=" + creationDate + ", username=" + username + "]";
	}

	
	
	
	
}
