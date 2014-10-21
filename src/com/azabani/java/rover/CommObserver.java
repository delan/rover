package com.azabani.java.rover;

public class CommObserver implements DeviceObserver {
	private ConcreteComm comm;
	private RoverController controller;
	public CommObserver(ConcreteComm comm, RoverController controller) {
		this.comm = comm;
		this.controller = controller;
		comm.addObserver(this);
	}
	public void update(Object x) {
		controller.messageReceived((String) x);
	}
}
