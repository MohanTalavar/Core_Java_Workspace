package com.app.core;

import java.time.LocalDate;

public class Vehicle implements Comparable<Vehicle>{               // BY $ME
	
	private String chasisNo;
	private Color vehicleColor;
	private double netprice;
	private LocalDate manufacturingDate;
	private String company;
	private boolean isAvailable;
	
	// para constr
	public Vehicle(String chasisNo, Color vehicleColor, double netprice, LocalDate manufacturingDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.netprice = netprice;
		this.manufacturingDate = manufacturingDate;
		this.company = company;
		this.isAvailable=true;
	}
	
	public Vehicle(String chasisNo)
	{
		this.chasisNo = chasisNo;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", netprice=" + netprice
				+ ", manufacturingDate=" + manufacturingDate + ", company=" + company + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		
		System.out.println("in vechicles equals");
		if(o instanceof Vehicle)
			return this.chasisNo.equals( ((Vehicle)o).chasisNo );
		return false;
	}
	
	@Override
	public int compareTo(Vehicle o) {
		
		System.out.println("In vehicles compareTo");
		return this.chasisNo.compareTo(o.chasisNo);
		
	}

	public Color getVehicleColor() {
		return vehicleColor;
	}

	public double getNetprice() {
		return netprice;
	}

	public void setNetprice(double netprice) {
		this.netprice = netprice;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	
	
	
	
	
	

}
