package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */

public class ChickReception {
	private String chicReceptionId;
	private Date visitDate;
	private String centerId;
	private String farmId;
	private String  housesId;
	private String  flockId;
	private String breed;
	private Date hatchDate;
	private String chickPlaced;
	private String psOrigin;
	private int psAge;
	private int navelNotclosedStrungButton;
	private int navelCleanWellHealed ;
	private int navelClosedSlightAbrasiveness;
	private int legsCleanWaxy;
	private int legsDrynessPale;
	private int legsDeshydratedVienProtruding;
	private int hocksCleanNoblemishes;
	private int hocksSlightBlushing;
	private int hocksRedcolorHeavyblushing;
	private int defectsCleanNodefects;
	private int defectsMinorDefects;
	private int defectsEyeLegsSpraddled;
	private int totalScore;
	private Date creationDate;
	private House house;
	private Center center;
	private Flock flock;
	
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getChicReceptionId() {
		return chicReceptionId;
	}
	public void setChicReceptionId(String chicReceptionId) {
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
	public int getNavelNotclosedStrungButton() {
		return navelNotclosedStrungButton;
	}
	public void setNavelNotclosedStrungButton(int navelNotclosedStrungButton) {
		this.navelNotclosedStrungButton = navelNotclosedStrungButton;
	}
	public int getNavelCleanWellHealed() {
		return navelCleanWellHealed;
	}
	public void setNavelCleanWellHealed(int navelCleanWellHealed) {
		this.navelCleanWellHealed = navelCleanWellHealed;
	}
	public int getNavelClosedSlightAbrasiveness() {
		return navelClosedSlightAbrasiveness;
	}
	public void setNavelClosedSlightAbrasiveness(int navelClosedSlightAbrasiveness) {
		this.navelClosedSlightAbrasiveness = navelClosedSlightAbrasiveness;
	}
	public int getLegsCleanWaxy() {
		return legsCleanWaxy;
	}
	public void setLegsCleanWaxy(int legsCleanWaxy) {
		this.legsCleanWaxy = legsCleanWaxy;
	}
	public int getLegsDrynessPale() {
		return legsDrynessPale;
	}
	public void setLegsDrynessPale(int legsDrynessPale) {
		this.legsDrynessPale = legsDrynessPale;
	}
	public int getLegsDeshydratedVienProtruding() {
		return legsDeshydratedVienProtruding;
	}
	public void setLegsDeshydratedVienProtruding(int legsDeshydratedVienProtruding) {
		this.legsDeshydratedVienProtruding = legsDeshydratedVienProtruding;
	}
	public int getHocksCleanNoblemishes() {
		return hocksCleanNoblemishes;
	}
	public void setHocksCleanNoblemishes(int hocksCleanNoblemishes) {
		this.hocksCleanNoblemishes = hocksCleanNoblemishes;
	}
	public int getHocksSlightBlushing() {
		return hocksSlightBlushing;
	}
	public void setHocksSlightBlushing(int hocksSlightBlushing) {
		this.hocksSlightBlushing = hocksSlightBlushing;
	}
	public int getHocksRedcolorHeavyblushing() {
		return hocksRedcolorHeavyblushing;
	}
	public void setHocksRedcolorHeavyblushing(int hocksRedcolorHeavyblushing) {
		this.hocksRedcolorHeavyblushing = hocksRedcolorHeavyblushing;
	}
	public int getDefectsCleanNodefects() {
		return defectsCleanNodefects;
	}
	public void setDefectsCleanNodefects(int defectsCleanNodefects) {
		this.defectsCleanNodefects = defectsCleanNodefects;
	}
	public int getDefectsMinorDefects() {
		return defectsMinorDefects;
	}
	public void setDefectsMinorDefects(int defectsMinorDefects) {
		this.defectsMinorDefects = defectsMinorDefects;
	}
	public int getDefectsEyeLegsSpraddled() {
		return defectsEyeLegsSpraddled;
	}
	public void setDefectsEyeLegsSpraddled(int defectsEyeLegsSpraddled) {
		this.defectsEyeLegsSpraddled = defectsEyeLegsSpraddled;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Center getCenter() {
		return center;
	}
	public void setCenter(Center center) {
		this.center = center;
	}
	public Flock getFlock() {
		return flock;
	}
	public void setFlock(Flock flock) {
		this.flock = flock;
	}
	@Override
	public String toString() {
		return "ChickReception [chicReceptionId=" + chicReceptionId + ", visitDate=" + visitDate + ", centerId="
				+ centerId + ", farmId=" + farmId + ", housesId=" + housesId + ", flockId=" + flockId + ", breed="
				+ breed + ", hatchDate=" + hatchDate + ", chickPlaced=" + chickPlaced + ", psOrigin=" + psOrigin
				+ ", psAge=" + psAge + ", navelNotclosedStrungButton=" + navelNotclosedStrungButton
				+ ", navelCleanWellHealed=" + navelCleanWellHealed + ", navelClosedSlightAbrasiveness="
				+ navelClosedSlightAbrasiveness + ", legsCleanWaxy=" + legsCleanWaxy + ", legsDrynessPale="
				+ legsDrynessPale + ", legsDeshydratedVienProtruding=" + legsDeshydratedVienProtruding
				+ ", hocksCleanNoblemishes=" + hocksCleanNoblemishes + ", hocksSlightBlushing=" + hocksSlightBlushing
				+ ", hocksRedcolorHeavyblushing=" + hocksRedcolorHeavyblushing + ", defectsCleanNodefects="
				+ defectsCleanNodefects + ", defectsMinorDefects=" + defectsMinorDefects + ", defectsEyeLegsSpraddled="
				+ defectsEyeLegsSpraddled + ", totalScore=" + totalScore + ", creationDate=" + creationDate + ", house="
				+ house + ", center=" + center + ", flock=" + flock + "]";
	}
	
	
	
	
	
}
