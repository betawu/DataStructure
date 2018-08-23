package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 寻路
 * @author beta
 *
 */
public class Path {
	private Graph g;
	private boolean[] v;//顶点是否被访问
	private int[] from;//顶点上一个顶点
	private int s;//起始顶点
	
	public Path(Graph g,int s) {
		this.g = g;
		this.s = s;
		this.v = new boolean[g.V()];
		this.from = new int[g.V()];
		for(int i=0;i<g.V();i++) {
			v[i] = false;
			from[i] = -1;
		}
		
		bfs(s);
	}

	private void bfs(int s) {
		v[s] = true;
		List<Integer> list = g.adj(s);
		for (Integer i : list) {
			from[i] = s;
			if(!v[i]) {
				bfs(i);
			}
		}
	}

	public List<Integer> hasPath(int w){
		List<Integer> list = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		
		while(w!=-1) {
			s.push(w);
			w = from[w];
		}
		
		while(!s.isEmpty()) {
			list.add(s.pop());
		}
		
		return list;
	}
	
	public void showPath(int w) {
		List<Integer> list = hasPath(w);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
