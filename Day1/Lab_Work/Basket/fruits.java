package com.app;

public abstract class fruits {

	private String color, name;
	private double weight;
	private boolean isFresh;

	public fruits(String name, String color, double weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
		this.isFresh = true;
	}

	public abstract String taste();
	
	public String getName() {

		return name;
	}

	public String getColor() {

		return color;
	}

	public double getWeight() {

		return weight;
	}

	public boolean getIsFresh() {

		return isFresh;
	}

	public void setName(String name) {

		this.name= name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}
	
	@Override
	public String toString() {
		
		return "Name: " +name + " Color: " + color + " Weight: " + weight+ " ";
	}
	

}// end
