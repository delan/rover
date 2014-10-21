package com.azabani.java.rover;

import java.util.Stack;
import java.util.Iterator;

public class RoverCommandCodec {
	public String encode(RoverCommand c) {
		return c.toString();
	}
	public RoverTaskList decode(
		String s,
		RoverListList program,
		Stack<Iterator<RoverCommand>> stack,
		ConcreteDriver driver,
		ConcreteSoilAnalyser soilAnalyser,
		ConcreteCamera camera
	) {
		RoverTaskList result = new RoverTaskList();
		String[] tasks = s.split(";");
		for (String task : tasks) {
			String[] tokens = task.split(":", 2);
			String kind = tokens[0];
			if (kind.equals("rotate")) {
				double angle = Double.parseDouble(tokens[1]);
				RotationCommand command =
					new RotationCommand(angle);
				command.setDriver(driver);
				result.add(command);
			} else if (kind.equals("translate")) {
				double dist = Double.parseDouble(tokens[1]);
				TranslationCommand command =
					new TranslationCommand(dist);
				command.setDriver(driver);
				result.add(command);
			} else if (kind.equals("analyse")) {
				AnalysisCommand command =
					new AnalysisCommand();
				command.setSoilAnalyser(soilAnalyser);
				result.add(command);
			} else if (kind.equals("photograph")) {
				PhotographyCommand command =
					new PhotographyCommand();
				command.setCamera(camera);
				result.add(command);
			} else if (kind.equals("call")) {
				int listIndex = Integer.parseInt(tokens[1]);
				RecursionCommand command =
					new RecursionCommand(listIndex);
				command.setProgram(program);
				command.setStack(stack);
				result.add(command);
			} else {
				throw new IllegalArgumentException(
					"invalid command string"
				);
			}
		}
		return result;
	}
}
