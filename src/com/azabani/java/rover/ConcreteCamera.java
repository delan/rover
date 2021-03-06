package com.azabani.java.rover;

import com.azabani.java.rover.fake.Camera;
import java.util.List;
import java.util.LinkedList;

public class ConcreteCamera extends Camera
	implements ObservableDevice {
	private List<DeviceObserver> observers;
	public ConcreteCamera() {
		super();
		observers = new LinkedList<DeviceObserver>();
	}
	protected void photoReady(char[] photoData) {
		notifyObservers(photoData);
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
