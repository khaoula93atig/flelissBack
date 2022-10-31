package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class FeedConsumption {

	private int breed;
	private int age_days;
	private double daily_feed_consumption;
	private double cumultive_feed_consumption;
	private double cumulative_feed_conversion_fcr;
    private Date creationDate;
	public int getBreed() {
		return breed;
	}
	public void setBreed(int breed) {
		this.breed = breed;
	}
	public int getAge_days() {
		return age_days;
	}
	public void setAge_days(int age_days) {
		this.age_days = age_days;
	}
	public double getDaily_feed_consumption() {
		return daily_feed_consumption;
	}
	public void setDaily_feed_consumption(double daily_feed_consumption) {
		this.daily_feed_consumption = daily_feed_consumption;
	}
	public double getCumultive_feed_consumption() {
		return cumultive_feed_consumption;
	}
	public void setCumultive_feed_consumption(double cumultive_feed_consumption) {
		this.cumultive_feed_consumption = cumultive_feed_consumption;
	}
	public double getCumulative_feed_conversion_fcr() {
		return cumulative_feed_conversion_fcr;
	}
	public void setCumulative_feed_conversion_fcr(double cumulative_feed_conversion_fcr) {
		this.cumulative_feed_conversion_fcr = cumulative_feed_conversion_fcr;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "FeedConsumption [breed=" + breed + ", age_days=" + age_days + ", daily_feed_consumption="
				+ daily_feed_consumption + ", cumultive_feed_consumption=" + cumultive_feed_consumption
				+ ", cumulative_feed_conversion_fcr=" + cumulative_feed_conversion_fcr + " creationDate=" + creationDate + "]";
	}

	

}
