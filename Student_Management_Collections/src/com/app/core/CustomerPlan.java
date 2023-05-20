package com.app.core;

//enum for pan and its rate
public enum CustomerPlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM (10000);
	
	private double charges;
	
	private CustomerPlan(double charges) {
		this.charges=charges;
		
	}
	
	public	double getCharges() {
			return charges;
		}
	
	@Override
	public String toString() {
		return name () + " @" + charges;
	}
	
	}


