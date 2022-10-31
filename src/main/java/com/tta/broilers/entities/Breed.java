package com.tta.broilers.entities;

/**
 * @author rym lamouchi
 *
 */

public class Breed {
	private int breedID; // id
	private String description; // name

	public int getBreedID() {
		return breedID;
	}

	public void setBreedID(int breedID) {
		this.breedID = breedID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Breed [breedID=" + breedID + ", description=" + description + "]";
	}

}
