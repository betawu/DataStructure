package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 带权重的稠密图-临接矩阵表示
 * @author beta
 *
 */
public class DenseWeightGraph implements WeightGraph {

	private int v;//顶点个数
	private int e;//边的个数
	private boolean directed;//是否是有向图
	private int[][] g;
	
	public DenseWeightGraph(int v, boolean directed) {
		this.v = v;
		this.e = 0;
		this.directed = directed;
		this.g = new int[v][v];
	}
	
	public boolean hasEdge(int m, int n) {
		return g[m][n] > 0;
	}
	
	public void add(int m, int n, int weight) {
		if (!hasEdge(m, n)) {
			g[m][n] = weight;
			if (!directed) {
				g[n][m] = weight;
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
	public List<Edge> getAdj(int m){
		List<Edge> list = new ArrayList<>();
		int[] arr = g[m];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				list.add(new Edge(m, i, arr[i]));
			}
		}
		return list;
	}
}
