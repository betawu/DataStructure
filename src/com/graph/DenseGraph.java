package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接矩阵
 * @author beta
 *
 */
public class DenseGraph implements Graph{

	private int m;//顶点的个数
	private int n;//边的个数
	private boolean[][] g;
	private	boolean directed;//是否是无向图
	
	public DenseGraph(int m,boolean directed) {
		this.m = m;
		this.directed = directed;
		g = new boolean[m][m];
		this.n = 0;
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
		
		g[v][w] = true;
		if(!directed) {
			g[w][v] = true;
		}
		n++;
	}

	@Override
	public boolean hasEdge(int v, int w) {
		return g[v][w];
	}

	@Override
	public List<Integer> adj(int i) {
		List<Integer> list = new ArrayList<>();
		for(int j = 0;j<m;j++) {
			if(g[i][j]) {
				list.add(j);
			}
		}
		return list;
	}

	@Override
	public void show() {
		for (boolean[] bs : g) {
			for (boolean b : bs) {
				if(b) {
					System.out.print(1+" ");
				}else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}
	}

}
