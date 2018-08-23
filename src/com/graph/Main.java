package com.graph;

public class Main {
	public static void main(String[] args) {
		DenseGraph g = new DenseGraph(4,false);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		Components c = new Components(g);
		System.out.println(c.getNum());
		g.show();
	}
}
