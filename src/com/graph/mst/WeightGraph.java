package com.graph.mst;

import java.util.List;

public interface WeightGraph {

	public void add(int m, int n, int weight);
	
	public List<Edge> getAdj(int m);
	
	public int E();
	
	public int V();
	
	public boolean hasEdge(int m, int n);
	
}
