package com.graph.base;

import java.util.List;

/**
 * 深度优先遍历 获取联通分量的数量
 * @author beta
 *
 */
public class Component {
	
	private Graph g;

	//连通分量的个数
	private int count;

	private boolean[] visited;
	
	private int[] c;//相同连通分量值相同
	
	public Component(Graph g) {
		this.g = g;
		this.visited = new boolean[g.V()];
		this.c = new int[g.V()];
		for (int i = 0; i < c.length; i++) {
			c[i] = -1;
		}
		for (int i = 0; i < g.V(); i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
	}

	//深度优先遍历
	private void dfs(int i) {
		visited[i] = true;
		c[i] = count;
		List<Integer> list = g.getAdj(i);
		for (Integer n : list) {
			if (!visited[n]) {
				dfs(n);
			}
		}
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean isConnected(int m, int n) {
		return c[m] == c[n];
	}
}
