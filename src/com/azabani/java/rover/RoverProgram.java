package com.azabani.java.rover;

public class RoverProgram {
	public static void main(String[] args) {
		ConcreteComm comm =
			new ConcreteComm();
		ConcreteDriver driver =
			new ConcreteDriver();
		ConcreteSoilAnalyser soilAnalyser =
			new ConcreteSoilAnalyser();
		ConcreteCamera camera =
			new ConcreteCamera();
		RoverController controller =
			new RoverController(
				comm,
				driver,
				soilAnalyser,
				camera
			);
		controller.start();
	}
}
