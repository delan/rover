package com.azabani.java.rover;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class RoverTaskList implements Iterable<RoverCommand> {
	private List<RoverCommand> commands;
	public RoverTaskList() {
		commands = new ArrayList<RoverCommand>();
	}
	public void add(RoverCommand c) {
		commands.add(c);
	}
	public Iterator<RoverCommand> iterator() {
		return Collections.unmodifiableList(commands).iterator();
	}
}
