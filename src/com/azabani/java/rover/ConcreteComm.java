package com.azabani.java.rover;

import com.azabani.java.rover.fake.Comm;
import java.util.List;
import java.util.LinkedList;

public class ConcreteComm extends Comm implements ObservableDevice {
	private List<DeviceObserver> observers;
	public ConcreteComm() {
		observers = new LinkedList<DeviceObserver>();
	}
	protected void receive(String message) {
		notifyObservers(message);
	}
	public void addObserver(DeviceObserver o) {
		observers.add(o);
	}
	public void deleteObserver(DeviceObserver o) {
		observers.remove(o);
	}
	public void notifyObservers(Object x) {
		for (DeviceObserver o : observers)
			o.update(x);
	}
}
