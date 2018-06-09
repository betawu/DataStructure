package com.unionfind;

import java.util.Arrays;

/**
 * 
 * @author beta
 *路径压缩
 */
public class UnionFind5 implements UF{

	private int[] parent;
	private int[] rank;
	
	public UnionFind5(int size) {
		this.parent = new int[size];
		this.rank = new int[size];
		for(int i=0;i<size;i++) {
			this.parent[i] = i;
			this.rank[i] = 1;
		}
	}
	
	private int find(int i) {
		while(parent[i] != i) {
			parent[i] = parent[parent[i]];
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
		UnionFind5 uf = new UnionFind5(5);
		int[] arr= {0,0,1,2,3};
		uf.parent = arr;
		System.out.println(Arrays.toString(uf.parent));
		uf.find(4);
		System.out.println(Arrays.toString(uf.parent));
		
	}
}