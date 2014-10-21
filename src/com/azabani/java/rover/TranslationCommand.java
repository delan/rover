package com.azabani.java.rover;

public class TranslationCommand implements RoverCommand {
	double distance; // forward metres, |distance| <= 100
	public TranslationCommand(double distance)
		throws IllegalArgumentException {
		if (Double.isNaN(distance) || Math.abs(distance) > 100.0)
			throw new IllegalArgumentException(
				"|distance| must not exceed 100.0"
			);
		this.distance = distance;
	}
	public void execute(/* TODO: Driver d */) {
		// TODO: Driver.drive(distance);
	}
}
