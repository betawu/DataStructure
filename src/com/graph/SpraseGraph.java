package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接表
 * @author beta
 *
 */
public class SpraseGraph implements Graph{
	private int m;//顶点个数
	private int n;//边的个数
	private List<Integer>[] g;
	private boolean directed;//是否是有向图
	
	public SpraseGraph(int m,boolean directed) {
		this.m = m;
		this.directed = directed;
		this.n = 0;
		g = new ArrayList[m];
		for (List<Integer> list : g) {
			list = new ArrayList<>();
		}
	}

	@Override
	public int V() {
		return m;
	}

	@Override
	public int E() {
		return n;
	}

	@Override
	public void addEdge(int v, int w) {
		if(hasEdge(v, w)) {
			return ;
		}
		
		g[v].add(w);
		if(!directed) {
			g[w].add(v);
		}
		
		n++;
	}

	@Override
	public boolean hasEdge(int v, int w) {
		for (Integer i : g[v]) {
			if(i==w) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Integer> adj(int i) {
		return g[i];
	}

	@Override
	public void show() {
		for (int i=0;i<m;i++) {
			System.out.print(i+":");
			for (Integer j :g[i]) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
