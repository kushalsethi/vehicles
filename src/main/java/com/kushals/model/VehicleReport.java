package com.kushals.model;

public class VehicleReport {
	private String vehicleType;
	private String vehicleId;
	private String frameMaterial;
	private String powerTrain;
	private int numOfWheels;
	private String timeStamp;
	private String fileName;

	public VehicleReport(String vehicleType, String vehicleId, String frameMaterial, String powerTrain, int numOfWheels,
			String timeStamp, String fileName) {
		this.vehicleType = vehicleType;
		this.vehicleId = vehicleId;
		this.frameMaterial = frameMaterial;
		this.powerTrain = powerTrain;
		this.numOfWheels = numOfWheels;
		this.timeStamp = timeStamp;
		this.fileName = fileName;
	}

	public static class Builder {

		private String vehicleType;
		private String vehicleId;
		private String frameMaterial;
		private String powerTrain;
		private int numOfWheels;
		private String timeStamp;
		private String fileName;

		public Builder setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
			return this;
		}

		public Builder setVehicleId(String vehicleId) {
			this.vehicleId = vehicleId;
			return this;
		}

		public Builder setFrameMaterial(String frameMaterial) {
			this.frameMaterial = frameMaterial;
			return this;
		}

		public Builder setPowerTrain(String powerTrain) {
			this.powerTrain = powerTrain;
			return this;
		}

		public Builder setNumOfWheels(int numOfWheels) {
			this.numOfWheels = numOfWheels;
			return this;
		}

		public Builder setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
			return this;
		}

		public Builder setFileName(String fileName) {
			this.fileName = fileName;
			return this;
		}

		public VehicleReport build() {
			return new VehicleReport(vehicleType, vehicleId, frameMaterial, powerTrain, numOfWheels, timeStamp,
					fileName);
		}

	}

	public String getVehicleType() {
		return vehicleType;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getFrameMaterial() {
		return frameMaterial;
	}

	public String getPowerTrain() {
		return powerTrain;
	}

	public int getNumOfWheels() {
		return numOfWheels;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getFileName() {
		return fileName;
	}

}
