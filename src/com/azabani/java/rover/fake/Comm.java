package com.azabani.java.rover.fake;

public abstract class Comm {
	public void send(String message) {
		System.err.println("Comm.send: \"" + message + "\"");
	}
	protected abstract void receive(String message);
}
