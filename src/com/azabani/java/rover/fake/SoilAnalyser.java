package com.azabani.java.rover.fake;

public abstract class SoilAnalyser {
	public void analyse() {
		System.err.println("SoilAnalyser.analyse");
	}
	protected abstract void analysisReady(String soilAnalysis);
}
