package com.graph.mst;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import com.heap.MaxHeap;

/**\
 * Lazy prim 最小生成树
 * @author beta
 *
 */

public class LazyPrimMst {
	
	private int weight;//最小生成树的权数和
	
	private WeightGraph g;
	
	private List<Edge> mst;//最小生成树

	private boolean[] visited;
	
	private MaxHeap<Edge> h;
	
	public LazyPrimMst(WeightGraph g) {
		this.g = g;
		mst = new ArrayList<>();
		visited = new boolean[g.V()];
		
		h = new MaxHeap<>();
		visit(0);
		while (!h.isEmpty()) {
			Edge e = h.extractMax();
			if (visited[e.getM()] && visited[e.getN()]) {
				continue;
			}
			mst.add(e);
			weight += e.getWieght();
			if (visited[e.getM()]) {
				visit(e.getN());
			}
			else {
				visit(e.getM());
			}
		}
	}

	private void visit(int i) {
		visited[i] = true;
		List<Edge> adj = g.getAdj(i);
		for (Edge e : adj) {
			int other = e.other(i);
			if (!visited[other]) {
				h.add(e);
			}
		}
	}

	public int getWeight() {
		return weight;
	}

	public void showMst() {
		for (Edge e : mst) {
			System.out.println(e.getM() + "->" + e.getN());
		}
	}
	
}
