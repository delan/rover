package com.azabani.java.rover;

public class RotationCommand implements RoverCommand {
	double angle; // clockwise degrees, |angle| <= 180
	public RotationCommand(double angle)
		throws IllegalArgumentException {
		if (Double.isNaN(angle) || Math.abs(angle) > 180.0)
			throw new IllegalArgumentException(
				"|angle| must not exceed 180.0"
			);
		this.angle = angle;
	}
	public void execute(/* TODO: Driver d */) {
		// TODO: d.turn(angle);
	}
}
