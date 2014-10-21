package com.azabani.java.rover.fake;

public abstract class Comm {
	private class FakeCommThread extends Thread {
		Comm comm;
		public FakeCommThread(Comm comm) {
			this.comm = comm;
		}
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			while (true) {
				comm.receive("photograph;" +
					"analyse;" +
					"rotate:180;" +
					"translate:-100;" +
					"call:0"); // TODO
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {}
			}
		}
	}
	public Comm() {
		(new FakeCommThread(this)).start();
	}
	public void send(String message) {
	}
	protected abstract void receive(String message);
}
