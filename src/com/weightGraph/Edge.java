package com.weightGraph;

/**
 * 有权图的边
 * @author beta
 *
 */
public class Edge<T extends Number & Comparable> implements Comparable<Edge>{
	//有向图就是a->b
	private int a;
	private int b;
	
	private T w;//权重

	public T weight() {
		return w;
	}
	
	public Edge() {
	}

	public Edge(int a, int b, T w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return w.compareTo((T) o.w);
	}

	public int other(int i) {
		return (i==a)?a:b;
	}

	@Override
	public String toString() {
		return a+"->"+b+":"+w+" ";
	}
	
	
}
