package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class FeedRequirements {

	private int breed;
	private String element;
	private String unity;
	private double starter;
	private double grower;
	private double finisher1;
	private double finisher2;
	private String category;
	private double min_for_starter;
	private double max_for_starter;
	private double min_for_grower;
	private double max_for_grower;
	private double max_for_finisher1;
	private double min_for_finisher2;
	private double max_for_finisher2;
	private double min_for_finisher1;
	private Date creationDate;

	public int getBreed() {
		return breed;
	}

	public void setBreed(int breed) {
		this.breed = breed;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public double getStarter() {
		return starter;
	}

	public void setStarter(double starter) {
		this.starter = starter;
	}

	public double getGrower() {
		return grower;
	}

	public void setGrower(double grower) {
		this.grower = grower;
	}

	public double getFinisher1() {
		return finisher1;
	}

	public void setFinisher1(double finisher1) {
		this.finisher1 = finisher1;
	}

	public double getFinisher2() {
		return finisher2;
	}

	public void setFinisher2(double finisher2) {
		this.finisher2 = finisher2;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getMin_for_starter() {
		return min_for_starter;
	}

	public void setMin_for_starter(double min_for_starter) {
		this.min_for_starter = min_for_starter;
	}

	public double getMax_for_starter() {
		return max_for_starter;
	}

	public void setMax_for_starter(double max_for_starter) {
		this.max_for_starter = max_for_starter;
	}

	public double getMin_for_grower() {
		return min_for_grower;
	}

	public void setMin_for_grower(double min_for_grower) {
		this.min_for_grower = min_for_grower;
	}

	public double getMax_for_grower() {
		return max_for_grower;
	}

	public void setMax_for_grower(double max_for_grower) {
		this.max_for_grower = max_for_grower;
	}

	public double getMax_for_finisher1() {
		return max_for_finisher1;
	}

	public void setMax_for_finisher1(double max_for_finisher1) {
		this.max_for_finisher1 = max_for_finisher1;
	}

	public double getMin_for_finisher2() {
		return min_for_finisher2;
	}

	public void setMin_for_finisher2(double min_for_finisher2) {
		this.min_for_finisher2 = min_for_finisher2;
	}

	public double getMax_for_finisher2() {
		return max_for_finisher2;
	}

	public void setMax_for_finisher2(double max_for_finisher2) {
		this.max_for_finisher2 = max_for_finisher2;
	}

	public double getMin_for_finisher1() {
		return min_for_finisher1;
	}

	public void setMin_for_finisher1(double min_for_finisher1) {
		this.min_for_finisher1 = min_for_finisher1;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
