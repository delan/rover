package com.azabani.java.rover.fake;

import com.azabani.java.rover.RoverUtils;

public abstract class SoilAnalyser {
	private class FakeSoilAnalyserThread extends Thread {
		SoilAnalyser soilAnalyser;
		public FakeSoilAnalyserThread(SoilAnalyser soilAnalyser) {
			this.soilAnalyser = soilAnalyser;
		}
		public void run() {
			RoverUtils.sleep(1500);
			analysisReady("[fake soil analysis]");
		}
	}
	public void analyse() {
		(new FakeSoilAnalyserThread(this)).start();
	}
	protected abstract void analysisReady(String soilAnalysis);
}
