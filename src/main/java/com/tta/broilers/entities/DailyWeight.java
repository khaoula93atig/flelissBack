package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class DailyWeight {

	private int breed;
	private int age_days;
	private double weight;
	private double daily_gain;
	private double average_daily_gain; 
	private double cumulative_feed_conversion;
	private Date creationDate;
	private int week;

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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDaily_gain() {
		return daily_gain;
	}

	public void setDaily_gain(double daily_gain) {
		this.daily_gain = daily_gain;
	}

	public double getAverage_daily_gain() {
		return average_daily_gain;
	}

	public void setAverage_daily_gain(double average_daily_gain) {
		this.average_daily_gain = average_daily_gain;
	}

	public double getCumulative_feed_conversion() {
		return cumulative_feed_conversion;
	}

	public void setCumulative_feed_conversion(double cumulative_feed_conversion) {
		this.cumulative_feed_conversion = cumulative_feed_conversion;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return "DailyWeight [breed=" + breed + ", age_days=" + age_days + ", weight=" + weight + ", daily_gain="
				+ daily_gain + ", average_daily_gain=" + average_daily_gain + ", cumulative_feed_conversion="
				+ cumulative_feed_conversion + ", creationDate=" + creationDate + ", week=" + week + "]";
	}

	

}
