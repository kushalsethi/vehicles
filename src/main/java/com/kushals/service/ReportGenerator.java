package com.kushals.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kushals.model.Bicycle;
import com.kushals.model.BigWheel;
import com.kushals.model.Car;
import com.kushals.model.HangGlider;
import com.kushals.model.InputVehicle;
import com.kushals.model.Report;
import com.kushals.model.VehicleReport;

@Service
public class ReportGenerator {

	private Map<String, Report> allVehicleReports = new HashMap<>();
	private Report report;
	private static final String[] powerTrains = { "human", "internal combustion ", "bernoulli" };

	public Report generateReport(File file) {
		report = new Report();
		List<VehicleReport> vehicleReports = parseInputFile(file);
		report.setVehicleReport(vehicleReports);
		allVehicleReports.put(file.getName(), report);
		return report;
	}

	public Report getReport(String fileName) {
		return allVehicleReports.get(fileName);
	}

	public List<String> getAllReportsList() {
		return new LinkedList<>(allVehicleReports.keySet());
	}

	public List<VehicleReport> parseInputFile(File inputFile) {
		List<VehicleReport> vehicleReports = new LinkedList<>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList vehicleList = doc.getElementsByTagName("vehicle");

			for (int i = 0; i < vehicleList.getLength(); i++) {

				Node nNode = vehicleList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String id = eElement.getElementsByTagName("id").item(0).getTextContent();
					String frameMaterial = eElement.getElementsByTagName("frame").item(0).getTextContent().trim();
					Node wheelsNode = eElement.getElementsByTagName("wheels").item(0);
					int numOfWheels = 0;
					if (wheelsNode.getNodeType() == Node.ELEMENT_NODE) {
						Element wheelsElement = (Element) wheelsNode;
						numOfWheels = wheelsElement.getElementsByTagName("wheel").getLength();
					}
					Node powerTrainNode = eElement.getElementsByTagName("powertrain").item(0);
					String powerTrain = null;
					if (powerTrainNode.getNodeType() == Node.ELEMENT_NODE) {
						Element powerTrainElement = (Element) powerTrainNode;
						if (powerTrainElement.getElementsByTagName(powerTrains[0]).getLength() == 1) {
							powerTrain = powerTrains[0];
						}
						if (powerTrainElement.getElementsByTagName(powerTrains[1]).getLength() == 1) {
							powerTrain = powerTrains[1];
						}
						if (powerTrainElement.getElementsByTagName(powerTrains[2]).getLength() == 1) {
							powerTrain = powerTrains[2];
						}
					}
					InputVehicle inputVehicle = getVehicleType(id, frameMaterial, numOfWheels, powerTrain);
					VehicleReport vehicleReport = new VehicleReport.Builder()
							.setVehicleType(inputVehicle.getVehicleType()).setVehicleId(inputVehicle.getVehicleId())
							.setFrameMaterial(inputVehicle.getFrameMaterial())
							.setPowerTrain(inputVehicle.getPowerTrain()).setNumOfWheels(inputVehicle.getNoOfWheels())
							.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()))
							.setFileName(inputFile.getName()).build();
					vehicleReports.add(vehicleReport);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleReports;
	}

	private InputVehicle getVehicleType(String id, String frameMaterial, int numOfWheels, String powerTrain) {
		InputVehicle inputVehicle = new InputVehicle(id, frameMaterial, numOfWheels, powerTrain);
		VehicleComparator vc = new VehicleComparator();
		if (vc.compare(inputVehicle, new Bicycle()) == 0) {
			inputVehicle.setVehicleType(VehicleTypes.Bicycle.getType());
			report.bicycleCount++;
		} else if (vc.compare(inputVehicle, new BigWheel()) == 0) {
			inputVehicle.setVehicleType(VehicleTypes.BigWheel.getType());
			report.bigWheelCount++;
		} else if (vc.compare(inputVehicle, new HangGlider()) == 0) {
			inputVehicle.setVehicleType(VehicleTypes.HangGlider.getType());
			report.hangGliderCount++;
		} else if (vc.compare(inputVehicle, new Car()) == 0) {
			inputVehicle.setVehicleType(VehicleTypes.Car.getType());
			report.carCount++;
		}
		return inputVehicle;
	}

}

enum VehicleTypes {
	BigWheel("Big Wheel"), Bicycle("Bicycle"), HangGlider("Hang Glider"), Car("Car");

	private String type;

	VehicleTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
