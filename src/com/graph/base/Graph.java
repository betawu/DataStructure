package com.graph.base;

import java.util.List;

public interface Graph {

	public void add(int m, int n);
	
	public List<Integer> getAdj(int m);
	
	public int E();
	
	public int V();
	
	public boolean hasEdge(int m, int n);
	
}
