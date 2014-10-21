package com.azabani.java.rover;

public class RotationCommand
	implements RoverCommand, AsynchronousCommand {
	private ConcreteDriver driver;
	private double angle; // clockwise degrees, |angle| <= 180
	public RotationCommand(double angle)
		throws IllegalArgumentException {
		if (Double.isNaN(angle) || Math.abs(angle) > 180.0)
			throw new IllegalArgumentException(
				"|angle| must not exceed 180.0"
			);
		this.angle = angle;
	}
	public void setDriver(ConcreteDriver driver) {
		this.driver = driver;
	}
	public void execute() {
		driver.turn(angle);
	}
	public String toString() {
		return "rotate:" + Double.toString(angle);
	}
}
