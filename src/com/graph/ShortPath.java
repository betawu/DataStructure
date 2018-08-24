package com.graph;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.linkedlist.LinkedList;

/**
 * 广度优先遍历和最短路径
 * @author beta
 *
 */
public class ShortPath {
	private Graph g;
	private boolean[] v;//顶点是否被访问过
	private int[] from;//顶点的上一个顶点
	private int[] ord;//顶点到起始点的距离
	private int s;//起始点
	
	public ShortPath(Graph g,int s) { 
		this.g = g;
		this.s = s;
		v = new boolean[s];
		from = new int[s];
		ord = new int[s];
		for(int i=0;i<g.V();i++) {
			v[i] = false;
			from[i] = -1;
			ord[i] = -1;
		}
		
		Queue<Integer> q = new java.util.LinkedList<>();
		ord[s] = 0;
		q.add(s);
		v[s]=true;
		while(!q.isEmpty()) {
			Integer i = q.remove();
			List<Integer> list = g.adj(s);
			for (Integer n : list) {
				if(!v[n]) {
					q.add(n);
					v[n]=true;
					ord[n]=ord[i]+1;
					from[n]=i;
				}
			}
		}
	}
	
	public boolean hasPath(int w) {
		return v[w];
	}
	
	public void showPath(int w) {
		Stack<Integer> s = new Stack<>();
		while(w!=-1) {
			s.push(w);
			w=from[w];
		}
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
