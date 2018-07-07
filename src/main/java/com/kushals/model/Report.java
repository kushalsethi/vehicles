package com.kushals.model;

import java.util.LinkedList;
import java.util.List;

public class Report {

	public int bigWheelCount;
	public int bicycleCount;
	public int carCount;
	public int motorcycleCount;
	public int hangGliderCount;

	private List<VehicleReport> vehicleReport = new LinkedList<>();
	
	public void setVehicleReport(List<VehicleReport> vehicleReport){
		this.vehicleReport = vehicleReport;
	}
	
	public List<VehicleReport> getVehicleReport(){
		return this.vehicleReport;
	}

}
