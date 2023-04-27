package com.app;

public class Mango extends fruits{

	public Mango(String name, String color, double weight) {
		super(name, color, weight);
		
	}
	
	public void pulp() {
		System.out.println("Extracting pulp");
	}

	@Override
	public String taste() {
		
		return "Sweet";
	}

	@Override
	public String toString() {
		return "Mango=" + super.toString() + "Taste: "+this.taste();
	}

}
