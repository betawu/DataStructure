package com.graph.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 利用广度优先遍历求最短路径
 * @author beta
 *
 */
public class Shortest {

	private Graph g;
	
	private boolean[] visisted;
	
	private int[] from;
	
	private int[] ord;//从起始顶点到该顶点的距离

	public Shortest(Graph g, int m) {
		this.g = g;
		visisted = new boolean[g.V()];
		from = new int[g.V()];
		ord = new int[g.V()];
		for (int i = 0; i < from.length; i++) {
			from[i] = -1;
			ord[i] = 0;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(m);
		visisted[m] = true;
		
		while (!q.isEmpty()) {
			Integer n = q.remove();
			List<Integer> list = g.getAdj(n);
			list.iterator().forEachRemaining((i)->{
				if (!visisted[i]) {
					q.add(i);
					visisted[i] = true;
					ord[i] = ord[n] + 1;
					from[i] = n;
				}
			});
		}
	}
	
	//从m到n的最短路径为多少
	public int length(int n) {
		return ord[n];
	}
	
	public boolean hasPath(int n) {
		return visisted[n];
	}
	
	public void showPath(int n) {
		Stack<Integer> s = new Stack<>();
		s.push(n);
		while (from[n] != -1) {
			int i = from[n];
			s.push(i);
			n = i;
		}
		
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
}
