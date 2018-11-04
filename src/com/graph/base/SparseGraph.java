package com.graph.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 临接表表示图
 * @author beta
 *
 */
public class SparseGraph implements Graph{
	private int v;
	private int e;
	private boolean directed;
	private List<List<Integer>> g;
	
	public SparseGraph(int v, boolean directed) {
		this.v = v;
		this.directed = directed;
		g = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			g.add(new ArrayList<>()); 
		}
	}
	
	@Override
	public void add(int m, int n) {
		if (m != n) {
			g.get(m).add(n);
			if (!directed) {
				g.get(n).add(m);
			}
			e++;
		}
	}
	
	@Override
	public boolean hasEdge(int m, int n) {
		List<Integer> list = g.get(m);
		return list.contains(n);
	}
	
	@Override
	public int V() {
		return v;
	}
	
	@Override
	public int E() {
		return e;
	}
	
	//获取顶点m相邻的边
	@Override
	public List<Integer> getAdj(int m){
		return g.get(m);
	}
}
