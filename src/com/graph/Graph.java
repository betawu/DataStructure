package com.graph;

import java.util.List;

public interface Graph {
	public int V();
	public int E();
	public void addEdge(int v,int w);
	public boolean hasEdge(int v,int w);
	public List<Integer> adj(int i);
	public void show();
}
