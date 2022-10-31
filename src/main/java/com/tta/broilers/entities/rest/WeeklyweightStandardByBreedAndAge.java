package com.tta.broilers.entities.rest;

public class WeeklyweightStandardByBreedAndAge {
	private int age;
	private float weight;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "WeeklyweightStandardByBreedAndAge [age=" + age + ", weight=" + weight + "]";
	}

	
	
}
