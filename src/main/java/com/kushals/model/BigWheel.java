package com.kushals.model;

public class BigWheel implements VehicleType{
	
	private final String vehicleType = "Big Wheel";
	
	private final String frameMaterial = "plastic";
	
	private final int noOfWheels = 3;
	
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
