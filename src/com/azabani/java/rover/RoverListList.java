package com.azabani.java.rover;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class RoverListList implements Iterable<RoverTaskList> {
	private List<RoverTaskList> lists;
	public RoverListList() {
		lists = new ArrayList<RoverTaskList>();
	}
	public void add(RoverTaskList c) {
		lists.add(c);
	}
	public RoverTaskList get(int i) {
		return lists.get(i);
	}
	public Iterator<RoverTaskList> iterator() {
		return Collections.unmodifiableList(lists).iterator();
	}
}
