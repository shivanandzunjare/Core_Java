package com.app;

public enum CustomerPlan {
	
	PLATINUM(2000),GOLD(1500),SILVER(1000);
	
	private double cost;
	private CustomerPlan(double cost) {
		this.cost=cost;
	}
	public double getCost() {
		return cost;
	}
	
	
	public String toString()
	{
		return name() + "@" + cost;
	}
	

}
