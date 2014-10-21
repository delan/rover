package com.azabani.java.rover.fake;

public abstract class Driver {
	private class FakeDriverThread extends Thread {
		Driver driver;
		public FakeDriverThread(Driver driver) {
			this.driver = driver;
		}
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
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
