package com.azabani.java.rover.fake;

import com.azabani.java.rover.RoverUtils;

public abstract class Camera {
	private class FakeCameraThread extends Thread {
		Camera camera;
		public FakeCameraThread(Camera camera) {
			this.camera = camera;
		}
		public void run() {
			RoverUtils.sleep(500);
			photoReady("[fake photo data]".toCharArray());
		}
	}
	public void takePhoto() {
		(new FakeCameraThread(this)).start();
	}
	protected abstract void photoReady(char[] photoData);
}
