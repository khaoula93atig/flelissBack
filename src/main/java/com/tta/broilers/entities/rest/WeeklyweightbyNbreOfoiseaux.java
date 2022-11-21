package com.tta.broilers.entities.rest;

public class WeeklyweightbyNbreOfoiseaux {
	private int count;
	private int weight;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "WeeklyweightbyNbreOfoiseaux [count=" + count + ", weight=" + weight + "]";
	}

}
