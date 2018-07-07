package com.kushals.model;

public class HangGlider implements VehicleType{
	
	private final String vehicleType = "Hang Glider";
	
	private final String frameMaterial = "plastic";
	
	private final int noOfWheels = 0;
	
	private final String powerTrain = "bernoulli";

	public String getVehicleType() {
		return this.vehicleType;
	}

	@Override
	public String getFrameMaterial() {
		return this.frameMaterial;
	}

	@Override
	public int getNoOfWheels() {
		return this.noOfWheels;
	}

	@Override
	public String getPowerTrain() {
		return this.powerTrain;
	}

}
