package com.graph;

import java.util.List;
import java.util.Stack;

/**
 * 深度优先遍历--寻路
 * @author beta
 *
 */
public class Path {
	
	private Graph g;
	
	private boolean[] visited;
	
	private int[] from;

	//m到其他顶点的路径
	public Path(Graph g, int m) {
		this.g = g;
		this.visited = new boolean[g.V()];
		this.from = new int[g.V()];
		for (int i = 0; i < g.V(); i++) {
			from[i] = -1;
		}
		
		List<Integer> list = g.getAdj(m);
		visited[m] = true;
		for (Integer j : list) {
			if (!visited[j]) {
				from[j] = m;
				dfs(j);
			}
		}
	}
	
	private void dfs(Integer i) {
		visited[i] = true;
		List<Integer> list = g.getAdj(i);
		for (Integer j : list) {
			if (!visited[j]) {
				from[j] = i;
				dfs(j);
			}
		}
	}

	public boolean hasPath(int n) {
		return visited[n];
	}
	
	//m到n的路径
	public void showPath(int n) {
		Stack<Integer> s = new Stack<>();
		s.push(n);
		while (from[n] != -1) {
			int i = from[n];
			s.push(i);
			n = i;
		}
		
		while (!s.isEmpty()) {
			Integer i = s.pop();
			System.out.print(i + " ");
		}
	}
}
