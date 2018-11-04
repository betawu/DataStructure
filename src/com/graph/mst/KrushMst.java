package com.graph.mst;

import java.util.ArrayList;
import java.util.List;

import com.heap.MaxHeap;
import com.unionfind.UnionFind1;

/**
 * krush最小生成树算法
 * @author beta
 */
public class KrushMst {
	
	private UnionFind1 uf;
	
	private List<Edge> mst;

	private MaxHeap<Edge> h;
	
	public KrushMst(WeightGraph g) {
		uf = new UnionFind1(g.V());
		mst = new ArrayList<>();
		h = new MaxHeap<>();
		
		for (int i = 0; i < g.V(); i++) {
			List<Edge> adj = g.getAdj(i);
			for (Edge e : adj) {
				if (e.getM() > e.getN()) {
					h.add(e);
				}
			}
		}
		
		while (mst.size() < g.V() - 1 ) {
			Edge e = h.extractMax();
			if (uf.isConnected(e.getM(), e.getN())) {
				continue;
			}
			uf.unionElements(e.getM(), e.getN());
			mst.add(e);
		}
	}
	
	public void showMst() {
		for (Edge e : mst) {
			System.out.println(e.getM() + "->" + e.getN());
		}
	}
}
