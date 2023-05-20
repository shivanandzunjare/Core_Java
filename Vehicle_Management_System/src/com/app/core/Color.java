package com.app.core;

public enum Color {  //enum class for vehicles colors with price
	
	WHITE(10000),RED(15000),BLACK(20000),SILVER(25000);

	private double colorCost;  //attribute
	
	private Color(double colorcost) {  //parameterized constructor
		this.colorCost=colorCost;
	}

	//getter for color cost
	public double getColorCost(){
		return colorCost;
	}
	
	@Override
	public String toString() {
		return name()+ " @"+ colorCost;
	}
	
	
}
