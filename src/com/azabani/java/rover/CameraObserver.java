package com.azabani.java.rover;

public class CameraObserver implements DeviceObserver {
	private ConcreteCamera camera;
	private RoverController controller;
	public CameraObserver(ConcreteCamera camera,
		RoverController controller) {
		this.camera = camera;
		this.controller = controller;
		camera.addObserver(this);
	}
	public void update(Object x) {
		controller.photographReceived((char[]) x);
	}
}
