package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author EMNA
 *
 */
//for weekly Feed
public class WeeklyFeed {

	private int breed;
	private String farmId;
	private String centerId;
	private String houseId;
	private String flockId;
	private int week;
	private double totalStarterFeed;
	private double starterFeedPerBird;
	private double totalGrowerFeed;
	private double growerFeedPerBird;
	private double totalFinisherFeed;
	private double finisherFeedBird;
	private Date creationDate;

	public int getBreed() {
		return breed;
	}

	public void setBreed(int breed) {
		this.breed = breed;
	}

	public String getFarmId() {
		return farmId;
	}

	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getFlockId() {
		return flockId;
	}

	public void setFlockId(String flockId) {
		this.flockId = flockId;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public double getTotalStarterFeed() {
		return totalStarterFeed;
	}

	public void setTotalStarterFeed(double totalStarterFeed) {
		this.totalStarterFeed = totalStarterFeed;
	}

	public double getStarterFeedPerBird() {
		return starterFeedPerBird;
	}

	public void setStarterFeedPerBird(double starterFeedPerBird) {
		this.starterFeedPerBird = starterFeedPerBird;
	}

	public double getGrowerFeedPerBird() {
		return growerFeedPerBird;
	}

	public void setGrowerFeedPerBird(double growerFeedPerBird) {
		this.growerFeedPerBird = growerFeedPerBird;
	}

	public double getTotalFinisherFeed() {
		return totalFinisherFeed;
	}

	public void setTotalFinisherFeed(double totalFinisherFeed) {
		this.totalFinisherFeed = totalFinisherFeed;
	}

	public double getFinisherFeedBird() {
		return finisherFeedBird;
	}

	public void setFinisherFeedBird(double finisherFeedBird) {
		this.finisherFeedBird = finisherFeedBird;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getTotalGrowerFeed() {
		return totalGrowerFeed;
	}

	public void setTotalGrowerFeed(double totalGrowerFeed) {
		this.totalGrowerFeed = totalGrowerFeed;
	}

	@Override
	public String toString() {
		return "WeeklyFeed [breed=" + breed + ", farmId=" + farmId + ", centerId=" + centerId + ", houseId=" + houseId
				+ ", flockId=" + flockId + ", week=" + week + ", totalStarterFeed=" + totalStarterFeed
				+ ", starterFeedPerBird=" + starterFeedPerBird + ", totalGrowerFeed=" + totalGrowerFeed
				+ ", growerFeedPerBird=" + growerFeedPerBird + ", totalFinisherFeed=" + totalFinisherFeed
				+ ", finisherFeedBird=" + finisherFeedBird + ", creationDate=" + creationDate + "]";
	}

}
