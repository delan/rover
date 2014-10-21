package com.azabani.java.rover;

import java.util.Stack;
import java.util.Iterator;

public class RoverController {
	private Stack<Iterator<RoverCommand>> stack;

	private ConcreteComm comm;
	private ConcreteDriver driver;
	private ConcreteSoilAnalyser soilAnalyser;
	private ConcreteCamera camera;

	private CommObserver commObserver;
	private DriverObserver driverObserver;
	private SoilAnalyserObserver soilAnalyserObserver;
	private CameraObserver cameraObserver;

	public RoverController(
		ConcreteComm comm,
		ConcreteDriver driver,
		ConcreteSoilAnalyser soilAnalyser,
		ConcreteCamera camera
	) {
		stack = new Stack<Iterator<RoverCommand>>();
		this.comm = comm;
		this.driver = driver;
		this.soilAnalyser = soilAnalyser;
		this.camera = camera;
		commObserver = new CommObserver(
			comm, this
		);
		driverObserver = new DriverObserver(
			driver, this
		);
		soilAnalyserObserver = new SoilAnalyserObserver(
			soilAnalyser, this
		);
		cameraObserver = new CameraObserver(
			camera, this
		);
	}
	public void start() {
		// TODO: write algorithm here
	}
	public void messageReceived(String message) {
		// TODO: write algorithm here
	}
	public void drivingAttempted(boolean success) {
		// TODO: write algorithm here
	}
	public void analysisReceived(String soilAnalysis) {
		// TODO: write algorithm here
	}
	public void photographReceived(char[] photoData) {
		// TODO: write algorithm here
	}
}
