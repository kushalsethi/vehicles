package com.kushals.model;

public class Bicycle implements VehicleType{

private final String vehicleType = "Bicycle";
	
	private final String frameMaterial = "metal";
	
	private final int noOfWheels = 2;
	
	private final String powerTrain = "human";

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
