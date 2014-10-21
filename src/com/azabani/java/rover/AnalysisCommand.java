package com.azabani.java.rover;

public class AnalysisCommand
	implements RoverCommand, AsynchronousCommand {
	ConcreteSoilAnalyser soilAnalyser;
	public void setSoilAnalyser(ConcreteSoilAnalyser soilAnalyser) {
		this.soilAnalyser = soilAnalyser;
	}
	public void execute() {
		soilAnalyser.analyse();
	}
	public String toString() {
		return "analyse";
	}
}
