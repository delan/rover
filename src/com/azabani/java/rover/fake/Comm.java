package com.azabani.java.rover.fake;

import com.azabani.java.rover.RoverUtils;

public abstract class Comm {
	private class FakeCommThread extends Thread {
		Comm comm;
		private final int sleeps[] = {
			1000, 10000, 0, 0
		};
		private final String messages[] = {
			"photograph;analyse;rotate:-180;translate:-100",
			"analyse;translate:-100;photograph;rotate:-180",
			"call:0;call:1;call:0",
			"call:2;call:1"
		};
		public FakeCommThread(Comm comm) {
			this.comm = comm;
		}
		public void run() {
			RoverUtils.sleep(1000);
			for (int i = 0; i < messages.length; i++) {
				comm.receive(messages[i]);
				RoverUtils.sleep(sleeps[i]);
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
