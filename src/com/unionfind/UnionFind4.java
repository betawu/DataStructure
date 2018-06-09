package com.unionfind;

import java.util.Arrays;

/**
 * 
 * @author beta
 *并查集
 *基于rank的优化（树的高度）
 */
public class UnionFind4 implements UF{

	private int[] parent;
	private int[] rank;
	
	public UnionFind4(int size) {
		this.parent = new int[size];
		this.rank = new int[size];
		for(int i=0;i<size;i++) {
			this.parent[i] = i;
			this.rank[i] = 1;
		}
	}
	
	private int find(int i) {
		while(i != parent[i]) {
			i = parent[i];
		}
		return i;
	}
	
	@Override
	public int getSize() {
		return parent.length;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		//比较俩个集合的树的高度
		//将高度小的树并到高度大的树上面
		if(rank[qRoot]<rank[pRoot]) {
			parent[qRoot] = pRoot;
		}else if(rank[qRoot]>rank[pRoot]) {
			parent[qRoot] = pRoot;
		}else {
			parent[qRoot] = pRoot;
			rank[pRoot] +=1;
		}
	}

	public static void main(String[] args) {
		UnionFind4 uf = new UnionFind4(10);
		System.out.println(Arrays.toString(uf.parent));
		uf.unionElements(0, 1);
		System.out.println(Arrays.toString(uf.parent));
		uf.unionElements(1, 2);
		System.out.println(Arrays.toString(uf.parent));
	}
}
