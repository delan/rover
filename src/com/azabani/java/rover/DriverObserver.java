package com.azabani.java.rover;

public class DriverObserver implements DeviceObserver {
	private ConcreteDriver driver;
	private RoverController controller;
	public DriverObserver(ConcreteDriver driver,
		RoverController controller) {
		this.driver = driver;
		this.controller = controller;
		driver.addObserver(this);
	}
	public void update(Object x) {
		boolean success = ((Boolean) x).booleanValue();
		controller.drivingAttempted(success);
	}
}
