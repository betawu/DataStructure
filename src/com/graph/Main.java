package com.graph;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		Graph g = ReadGraph.read(new File("text2.txt"), 2);
		Component c = new Component(g);
		System.out.println(c.getCount());
		System.out.println(c.isConnected(0, 5));
		Path p = new Path(g, 0);
		p.showPath(4);
		System.out.println();
		Shortest s = new Shortest(g, 0);
		s.showPath(4);
	}
}
