package com.azabani.java.rover;

public class TranslationCommand
	implements RoverCommand, AsynchronousCommand {
	private ConcreteDriver driver;
	private double distance; // forward metres, |distance| <= 100
	public TranslationCommand(double distance)
		throws IllegalArgumentException {
		if (Double.isNaN(distance) || Math.abs(distance) > 100.0)
			throw new IllegalArgumentException(
				"|distance| must not exceed 100.0"
			);
		this.distance = distance;
	}
	public void setDriver(ConcreteDriver driver) {
		this.driver = driver;
	}
	public void execute() {
		driver.drive(distance);
	}
	public String toString() {
		return "translate:" + Double.toString(distance);
	}
}
