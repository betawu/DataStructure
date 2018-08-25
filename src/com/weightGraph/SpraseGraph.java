package com.weightGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 带权重的邻接表
 * @author beta
 *
 */
public class SpraseGraph <T extends Number & Comparable>{
	private int m;
	private int n;
	private List<Edge<T>>[] g;
	private boolean directed;
	
	public SpraseGraph(int m, boolean directed) {
		this.m = m;
		this.n = 0;
		this.directed = directed;
		
		g = new ArrayList[m];
		for(int i=0;i<m;i++) {
			g[i] = new ArrayList<>();
		}
	}
	public int V() {
		return m;
	}
	
	public int E() {
		return n;
	}
	
	public void addEdge(int v,int w,T weight) {
		if(hasEdge(v, w)) {
			return ;
		}
		g[v].add(new Edge<T>(v, w, weight));
		if(!directed) {
			g[w].add(new Edge<T>(v, w, weight));
		}
		n++;
	}
	
	public boolean hasEdge(int v,int w) {
		List<Edge<T>> list =  g[v];
		for (Edge<T> e : list) {
			int i = e.other(v);
			if(i==w) {
				return true;
			}
		}
		return false;
	}
	
	public void show() {
		for (List<Edge<T>> list : g) {
			for (Edge<T> e : list) {
				e.toString();
			}
			System.out.println();
		}
	}
	
	public List<Edge<T>> adj(int v) {
		return g[v];
	}
}
