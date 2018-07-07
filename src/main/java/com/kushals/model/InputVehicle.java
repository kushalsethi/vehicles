package com.kushals.model;

public class InputVehicle implements VehicleType {

	private String vehicleType;

	private final String vehicleId;

	private final String frameMaterial;

	private final int noOfWheels;

	private final String powerTrain;

	public InputVehicle(String vehicleId, String frameMaterial, int noOfWheels, String powerTrain) {
		this.vehicleId = vehicleId;
		this.frameMaterial = frameMaterial;
		this.noOfWheels = noOfWheels;
		this.powerTrain = powerTrain;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public String getVehicleId() {
		return this.vehicleId;
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

	/*
	 * @Override public String toString() { return "vehicleType=" + vehicleType
	 * + ", vehicleId=" + vehicleId + ", frameMaterial=" + frameMaterial +
	 * ", noOfWheels=" + noOfWheels + ", powerTrain=" + powerTrain + "]"; }
	 */

	
	
}
