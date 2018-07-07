package com.kushals.service;

import java.util.Comparator;

import com.kushals.model.VehicleType;

public class VehicleComparator implements Comparator<VehicleType> {

	@Override
	public int compare(VehicleType one, VehicleType two) {
		if (one.getFrameMaterial().equalsIgnoreCase(two.getFrameMaterial())
				&& one.getNoOfWheels() == two.getNoOfWheels()
				&& one.getPowerTrain().equalsIgnoreCase(two.getPowerTrain()))
			return 0;
		return -1;
	}

}
