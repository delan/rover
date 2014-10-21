package com.azabani.java.rover;

public class PhotographyCommand
	implements RoverCommand, AsynchronousCommand {
	private ConcreteCamera camera;
	public void setCamera(ConcreteCamera camera) {
		this.camera = camera;
	}
	public void execute() {
		camera.takePhoto();
	}
	public String toString() {
		return "photograph";
	}
}
