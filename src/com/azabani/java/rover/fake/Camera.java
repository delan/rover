package com.azabani.java.rover.fake;

public abstract class Camera {
	public void takePhoto() {
		System.err.println("Camera.takePhoto");
	}
	protected abstract void photoReady(char[] photoData);
}
