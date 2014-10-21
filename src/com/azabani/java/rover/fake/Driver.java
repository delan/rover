package com.azabani.java.rover.fake;

import com.azabani.java.rover.RoverUtils;

public abstract class Driver {
	private class FakeDriverThread extends Thread {
		Driver driver;
		public FakeDriverThread(Driver driver) {
			this.driver = driver;
		}
		public void run() {
			RoverUtils.sleep(3000);
			if (Math.random() > 0.1)
				moveFinished();
			else
				mechanicalError();
		}
	}
	public void drive(double distance) {
		(new FakeDriverThread(this)).start();
	}
	public void turn(double angle) {
		(new FakeDriverThread(this)).start();
	}
	protected abstract void moveFinished();
	protected abstract void mechanicalError();
}
