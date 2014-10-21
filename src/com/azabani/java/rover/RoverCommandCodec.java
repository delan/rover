package com.azabani.java.rover;

public class RoverCommandCodec {
	public String encode(RoverCommand c) {
		return c.toString();
	}
	public RoverTaskList decode(String s) {
		RoverTaskList result = new RoverTaskList();
		String[] tasks = s.split(";");
		for (String task : tasks) {
			String[] tokens = task.split(":", 2);
			String kind = tokens[0];
			if (kind.equals("rotate")) {
				double angle = Double.parseDouble(tokens[1]);
				result.add(new RotationCommand(angle));
			} else if (kind.equals("translate")) {
				double dist = Double.parseDouble(tokens[1]);
				result.add(new TranslationCommand(dist));
			} else if (kind.equals("analyse")) {
				result.add(new AnalysisCommand());
			} else if (kind.equals("photograph")) {
				result.add(new PhotographyCommand());
			} else if (kind.equals("call")) {
				int listIndex = Integer.parseInt(tokens[1]);
				result.add(new RecursionCommand(listIndex));
			} else {
				throw new IllegalArgumentException(
					"invalid command string"
				);
			}
		}
		return result;
	}
}
