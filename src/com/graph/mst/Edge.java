package com.graph.mst;

public class Edge implements Comparable<Edge>{
	
	private int m;
	
	private int n;
	
	private int wieght;
	
	public Edge(int m, int n, int wieght) {
		super();
		this.m = m;
		this.n = n;
		this.wieght = wieght;
	}

	public int other(int v) {
		return m == v ? n : m;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public int getWieght() {
		return wieght;
	}

	@Override
	public int compareTo(Edge o) {
		int rs = o.getWieght() - wieght;
//		int rs = wieght - o.getWieght();
		if (rs == 0) {
			return 0;
		}
		else if (rs > 0) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
