package com.azabani.java.rover;

public class RoverCommandCodec {
	public static String encode(RoverCommand c) {
		return c.toString();
	}
	public static RoverCommand decode(String s) {
		String[] tokens = s.split(":", 2);
		String kind = tokens[0];
		if (kind.equals("rotate")) {
			double angle = Double.parseDouble(tokens[1]);
			return new RotationCommand(angle);
		} else if (kind.equals("translate")) {
			double distance = Double.parseDouble(tokens[1]);
			return new TranslationCommand(distance);
		} else if (kind.equals("analyse")) {
			return new AnalysisCommand();
		} else if (kind.equals("photograph")) {
			return new PhotographyCommand();
		} else if (kind.equals("call")) {
			int listIndex = Integer.parseInt(tokens[1]);
			return new RecursionCommand(listIndex);
		} else {
			throw new IllegalArgumentException(
				"invalid command string"
			);
		}
	}
}
