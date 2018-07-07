package com.kushals.model;

public class Car implements VehicleType{
	
	private final String vehicleType = "Car";
	
	private final String frameMaterial = "metal";
	
	private final int noOfWheels = 4;
	
	private final String powerTrain = "internal combustion";

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
