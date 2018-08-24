package com.spanGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 带权重的邻接矩阵
 * @author beta
 *
 */
public class DenseGraph<T extends Number & Comparable> {
	private int m;
	private int n;
	private Edge<T>[][] g;
	private boolean directed;
	public DenseGraph(int m, boolean directed) {
		this.m = m;
		this.directed = directed;
		this.n = 0;
		g = new Edge[m][m];
		for (int i=0;i<m;i++) {
			for (int j=0;j<m;j++) {
				g[i][j] = null;
			}
		}
	}
	
	public int V() {
		return m;
	}
	
	public int E() {
		return n;
	}
	
	public boolean hadEdge(int v,int w) {
		if(g[v][w] != null) {
			return true;
		}
		return false;
	}
	
	public void addEdge(int v,int w,T weight) {
		if (g[v][w] != null) {
			return ;
		}
		
		g[v][w] = new Edge<T>(v, w, weight);
		if(!directed) {
			g[w][v] = new Edge<T>(v, w, weight);
		}
		n++;
	}
	
	public void show() {
		for (Edge<T>[] edges : g) {
			for (Edge<T> e : edges) {
				if(e == null) {
					System.out.print("null ");
				}else {
					System.out.print(e.weight()+" ");
				}
			}
			System.out.println();
		}
	}
	
	public List<Edge<T>> adj(int v) {
		List<Edge<T>> list = new ArrayList<>();
		
		Edge<T>[] e = g[v];
		for(int i=0;i<e.length;i++) {
			if(e[i] != null) {
				list.add(e[i]);
			}
		}
		
		return list;
	}
}
