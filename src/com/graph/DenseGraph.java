package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图-临接矩阵表示
 * @author beta
 *
 */
public class DenseGraph implements Graph {

	private int v;//顶点个数
	private int e;//边的个数
	private boolean directed;//是否是有向图
	private boolean[][] g;
	
	public DenseGraph(int v, boolean directed) {
		this.v = v;
		this.e = 0;
		this.directed = directed;
		this.g = new boolean[v][v];
	}
	
	public boolean hasEdge(int m, int n) {
		return g[m][n];
	}
	
	public void add(int m, int n) {
		if (!hasEdge(m, n)) {
			g[m][n] = true;
			if (!directed) {
				g[n][m] = true;
			}
			e++;
		}
	}
	
	public int V() {
		return v;
	}
	
	public int E() {
		return e;
	}
	
	//获取顶点m相邻的边
	public List<Integer> getAdj(int m){
		List<Integer> list = new ArrayList<>();
		boolean[] arr = g[m];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				list.add(i);
			}
		}
		return list;
	}
}
