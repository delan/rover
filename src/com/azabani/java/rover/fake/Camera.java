package com.azabani.java.rover.fake;

public abstract class Camera {
	private class FakeCameraThread extends Thread {
		Camera camera;
		public FakeCameraThread(Camera camera) {
			this.camera = camera;
		}
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			photoReady("[fake photo data]".toCharArray());
		}
	}
	public void takePhoto() {
		(new FakeCameraThread(this)).start();
	}
	protected abstract void photoReady(char[] photoData);
}
