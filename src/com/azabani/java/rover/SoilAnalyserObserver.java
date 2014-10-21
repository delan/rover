package com.azabani.java.rover;

public class SoilAnalyserObserver implements DeviceObserver {
	private ConcreteSoilAnalyser soilAnalyser;
	private RoverController controller;
	public SoilAnalyserObserver(ConcreteSoilAnalyser soilAnalyser,
		RoverController controller) {
		this.soilAnalyser = soilAnalyser;
		this.controller = controller;
		soilAnalyser.addObserver(this);
	}
	public void update(Object x) {
		controller.analysisReceived((String) x);
	}
}
