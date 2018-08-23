package com.graph;

import java.util.List;

/**
 * 连通分量
 * @author beta
 *
 */
public class Components {
	private Graph g;
	private int[] ids;//用于表示每一个顶点的所在连通分量
	private boolean[] v;//用于表示每个顶点有没有被访问过
	private int count;//用于表示连通分量的个数
	
	public int getNum() {
		return count;
	}
	
	public Components(Graph g) {
		this.g = g;
		
		v = new boolean[g.V()];
		ids = new int[g.V()];
		for(int i=0;i<g.V();i++) {
			ids[i] = -1;
			v[i] = false;
		}
		this.count = 0;
		
		for(int i =0;i<g.V();i++) {
			if(!v[i]) {
				count++;
				bfs(i);
			}
		}
	}

	private void bfs(int i) {
		v[i] = true;
		ids[i] = count;
		List<Integer> list = g.adj(i);
		for (Integer j : list) {
			if (!v[j]) {
				bfs(j);
			}
		}
	}
	
	public boolean isConnection(int v,int w) {
		return ids[v] == ids[w];
	}
}
