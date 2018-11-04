package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 带权重的临接表表示的图
 * @author beta
 *
 */
public class SparseWeightGraph implements WeightGraph{
	private int v;
	private int e;
	private boolean directed;
	private List<List<int[]>> g;//int型数组第一位表示边，第二位表示权重
	
	public SparseWeightGraph(int v, boolean directed) {
		this.v = v;
		this.directed = directed;
		g = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			g.add(new ArrayList<>()); 
		}
	}
	
	@Override
	public void add(int m, int n, int weight) {
		if (m != n) {
			g.get(m).add(new int[] {n, weight});
			if (!directed) {
				g.get(n).add(new int[] {m, weight});
			}
			e++;
		}
	}
	
	@Override
	public boolean hasEdge(int m, int n) {
		List<int[]> list = g.get(m);
		for (int[] is : list) {
			if (is[0] == n) {
				return true;
			}
		}
		return false;
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
	public List<Edge> getAdj(int m){
		List<Edge> l = new ArrayList<>();
		List<int[]> list = g.get(m);
		for (int[] is : list) {
			l.add(new Edge(m, is[0], is[1]));
		}
		return l;
	}
}
