package com.tta.broilers.entities.rest;

public class MortalityByBreed {
	private int breed;
	private double number_initial;
	private double number_restant;
	private double mortality;
	
	public int getBreed() {
		return breed;
	}
	public void setBreed(int breed) {
		this.breed = breed;
	}
	public double getNumber_initial() {
		return number_initial;
	}
	public void setNumber_initial(double number_initial) {
		this.number_initial = number_initial;
	}
	public double getNumber_restant() {
		return number_restant;
	}
	public void setNumber_restant(double number_restant) {
		this.number_restant = number_restant;
	}
	public double getMortality() {
		return mortality;
	}
	public void setMortality(double mortality) {
		this.mortality = mortality;
	}
	@Override
	public String toString() {
		return "MortalityByBreed [breed=" + breed + ", number_initial=" + number_initial + ", number_restant="
				+ number_restant + ", mortality=" + mortality + "]";
	}

	
}
