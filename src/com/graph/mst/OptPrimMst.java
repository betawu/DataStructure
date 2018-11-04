package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 优化prim最小生成树算法
 * @author beta
 *
 */
public class OptPrimMst {
	
	private int weight;//最小生成树的权重和
	
	private WeightGraph g;
	
	private List<Edge> mst;
	
	private boolean[] visited;
	
	private IndexMaxHeap<Edge> h;

	public OptPrimMst(WeightGraph g) {
		this.g = g;
		visited = new boolean[g.V()];
		mst = new ArrayList<>();
		h = new IndexMaxHeap<>(10);
		
		visit(0);
		while (!h.isEmpty()) {
			Edge e = h.delMax();
			if (visited[e.getM()] && visited[e.getN()]) {
				continue ;
			}
			
			mst.add(h.delMax());
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
			if (!visited[e.other(i)]) {
				if ( h.get(e.other(i)) == null || h.get(e.other(i)).getWieght() > e.getWieght()) {
					try {
						h.insert(e.other(i), e);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
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
