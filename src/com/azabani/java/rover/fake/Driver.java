package com.azabani.java.rover.fake;

public abstract class Driver {
	public void drive(double distance) {
		System.err.println("Driver.drive: " +
			Double.toString(distance));
	}
	public void turn(double angle) {
		System.err.println("Driver.turn: " +
			Double.toString(angle));
	}
	protected abstract void moveFinished();
	protected abstract void mechanicalError();
}
