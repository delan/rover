package com.azabani.java.rover;

public interface ObservableDevice {
	void addObserver(DeviceObserver o);
	void deleteObserver(DeviceObserver o);
	void notifyObservers();
}
