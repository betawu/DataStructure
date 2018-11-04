package com.graph.mst;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		ReadGraph r = new ReadGraph();
		WeightGraph g = r.read(new File("text3.txt"), 2);
		LazyPrimMst mst = new LazyPrimMst(g);
		mst.showMst();
		
	}
}
