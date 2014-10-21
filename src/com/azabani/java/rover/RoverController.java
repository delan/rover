package com.azabani.java.rover;

import java.util.Stack;
import java.util.Iterator;

public class RoverController {
	private boolean busy;

	private RoverListList program;
	private Stack<Iterator<RoverCommand>> stack;

	private ConcreteComm comm;
	private ConcreteDriver driver;
	private ConcreteSoilAnalyser soilAnalyser;
	private ConcreteCamera camera;

	private CommObserver commObserver;
	private DriverObserver driverObserver;
	private SoilAnalyserObserver soilAnalyserObserver;
	private CameraObserver cameraObserver;

	public RoverController(
		ConcreteComm comm,
		ConcreteDriver driver,
		ConcreteSoilAnalyser soilAnalyser,
		ConcreteCamera camera
	) {
		busy = false;
		program = new RoverListList();
		stack = new Stack<Iterator<RoverCommand>>();
		this.comm = comm;
		this.driver = driver;
		this.soilAnalyser = soilAnalyser;
		this.camera = camera;
		commObserver = new CommObserver(
			comm, this
		);
		driverObserver = new DriverObserver(
			driver, this
		);
		soilAnalyserObserver = new SoilAnalyserObserver(
			soilAnalyser, this
		);
		cameraObserver = new CameraObserver(
			camera, this
		);
	}
	public void start() {
		int nextListIndex = 0;
		while (true) {
			if (!busy) {
				if (
					stack.empty() &&
					program.length() > nextListIndex
				) {
					System.err.printf(
						"%s: executing list #%d\n",
						"RoverController.start",
						nextListIndex
					);
					stack.push(
						program.get(nextListIndex).
						iterator()
					);
					nextListIndex++;
				} else if (
					!stack.empty() &&
					stack.peek().hasNext()
				) {
					busy = true;
					RoverCommand command =
						stack.peek().next();
					System.err.printf(
						"%s: executing task: %s\n",
						"RoverController.start",
						command.toString()
					);
					command.execute();
					if (!(
						command
						instanceof
						AsynchronousCommand
					))
						busy = false;
				} else if (
					!stack.empty() &&
					!stack.peek().hasNext()
				) {
					stack.pop();
				}
			}
			RoverUtils.sleep(100);
		}
	}
	public void messageReceived(String message) {
		RoverCommandCodec c = new RoverCommandCodec();
		RoverTaskList l = c.decode(
			message,
			program,
			stack,
			driver,
			soilAnalyser,
			camera
		);
		System.err.printf(
			"%s: new task list #%d with %d tasks\n",
			"RoverController.messageReceived",
			program.length(),
			l.length()
		);
		program.add(l);
	}
	public void drivingAttempted(boolean success) {
		System.err.printf(
			"%s: driving attempt %s\n",
			"RoverController.drivingAttempted",
			(success ? "succeeded" : "failed")
		);
		if (!success)
			stack.pop();
		comm.send("driving:" + (success ? "success" : "failure"));
		busy = false;
	}
	public void analysisReceived(String soilAnalysis) {
		System.err.printf(
			"%s: soil analysis received: %s\n",
			"RoverController.analysisReceived",
			soilAnalysis
		);
		comm.send("analyse:" + soilAnalysis);
		busy = false;
	}
	public void photographReceived(char[] photoData) {
		System.err.printf(
			"%s: photograph received: %s\n",
			"RoverController.photographReceived",
			new String(photoData)
		);
		String result = new String(photoData);
		comm.send("photograph:" + result);
		busy = false;
	}
}
