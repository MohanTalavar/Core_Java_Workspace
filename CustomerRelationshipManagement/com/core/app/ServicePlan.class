package com.core.app;

public enum ServicePlan {

	
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);
	
	private double planCharges;
	
	private ServicePlan(double planCharges) {
		
		this.planCharges=planCharges;
	}

	public double getPlanCharges() {
		return this.planCharges;
	}
	
	@Override 
	public String toString() {
		
		return name() + " cost:" + planCharges;
	}
}


