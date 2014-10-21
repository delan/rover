package com.azabani.java.rover;

import java.util.Stack;
import java.util.Iterator;

public class RecursionCommand implements RoverCommand {
	int listIndex; // non-negative
	RoverListList program;
	Stack<Iterator<RoverCommand>> stack;
	public RecursionCommand(int listIndex, RoverListList program,
		Stack<Iterator<RoverCommand>> stack)
		throws IllegalArgumentException {
		if (listIndex < 0)
			throw new IllegalArgumentException(
				"listIndex must not be negative"
			);
		this.listIndex = listIndex;
		this.program = program;
		this.stack = stack;
	}
	public void execute() {
		stack.push(program.get(listIndex).iterator());
	}
	public String toString() {
		return "call:" + Integer.toString(listIndex);
	}
}
