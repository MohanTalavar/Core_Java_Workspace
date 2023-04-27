package com.app;

public class Orange extends fruits {

	public Orange(String name, String color, double weight) {
		super(name, color, weight);
	}
	
	public void juice() {
		
		System.out.println("Preparing juice");
	}

	@Override
	public String taste() {
		
		return "Sour";
	}

	@Override
	public String toString() {
		return "Orange" + super.toString() +"Taste: "+this.taste();
	}

	
}
