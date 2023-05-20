package com.app.core;


import java.time.LocalDate; 
public class Vehicle implements Comparable<Vehicle>
{          //Vehicle class
	
	private String chasisNo;
	private Color vehicleColor;
	private double netPrice;
	private LocalDate manufactureDate;
	private String company;
	private boolean isAvailable;
	
	   //Parameterized constructor----------
	public Vehicle(String chasisNo, Color vehicleColor, double netPrice, LocalDate manufactureDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.netPrice = netPrice;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.isAvailable=true;
	}
	public Vehicle(String chasisNo)   //for primary key chasisNo //Constructor
	{
		this.chasisNo=chasisNo;
	}
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", netPrice=" + netPrice
				+ ", manufactureDate=" + manufactureDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}
	
	//equals method for checking duplication of vehicles
	// equality with Object o / ! not reference equaity
	public boolean equals(Object o) {
		System.out.println(" in vehicle equals");
		if(o instanceof Vehicle)
			return this.chasisNo.equals(((Vehicle)o).chasisNo);   //PK(UID) //checking chasisNo equality
		return false;
		
	}
	
	public int compareTo(Vehicle anotherVehicle ) {
		System.out.println(" in compare ---");
		
		return this.chasisNo.compareTo(anotherVehicle.chasisNo);
	}
	
	
	public void setVehicleColor(Color vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public double getBasePrice() {
		return netPrice;
	}
	public void setBasePrice(double basePrice) {
		this.netPrice = basePrice;
	}
	public Color getVehicleColor() {
		return vehicleColor;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	}
	
	