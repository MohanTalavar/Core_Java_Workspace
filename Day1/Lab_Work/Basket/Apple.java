package com.app;

public class Apple extends fruits{

	public Apple(String name, String color, double weight) {
		super(name, color, weight);
		
	}

	@Override
	public String taste() {
		
		return "Sweet & Sour";
	}

	public void jam() {
		System.out.println("Making jam");
	}
	@Override
	public String toString() {
		return "Apple:" + super.toString() +"Taste: "+this.taste();
	}


}
