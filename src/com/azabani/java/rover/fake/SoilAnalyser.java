package com.azabani.java.rover.fake;

public abstract class SoilAnalyser {
	private class FakeSoilAnalyserThread extends Thread {
		SoilAnalyser soilAnalyser;
		public FakeSoilAnalyserThread(SoilAnalyser soilAnalyser) {
			this.soilAnalyser = soilAnalyser;
		}
		public void run() {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {}
			analysisReady("[fake soil analysis]");
		}
	}
	public void analyse() {
		(new FakeSoilAnalyserThread(this)).start();
	}
	protected abstract void analysisReady(String soilAnalysis);
}
