package com.unionfind;

import java.util.Arrays;

/**
 * 
 * @author beta
 *基于size优化并查集
 */
public class UnionFind3 implements UF{

	private int[] parent;
	//每个元素下面连接有多少个元素
	private int[] num;
	
	public UnionFind3(int size) {
		this.parent = new int[size];
		this.num = new int[size];
		for(int i=0;i<size;i++) {
			parent[i] = i;
			num[i] = 1;
		}
	}
	
	private int find(int i) {
		if(i == parent[i]) {
			return i;
		}
		return find(parent[i]);
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
		if(num[qRoot]<num[pRoot]) {
			parent[qRoot] = pRoot;
			num[pRoot] +=num[qRoot];
		}else {
			parent[pRoot] = qRoot;
			num[qRoot] +=num[pRoot];
		}
	}
	
	public static void main(String[] args) {
		UnionFind3 uf = new UnionFind3(10);
		System.out.println(Arrays.toString(uf.parent));
		uf.unionElements(0, 1);
		System.out.println(Arrays.toString(uf.parent));
		uf.unionElements(1, 2);
		System.out.println(Arrays.toString(uf.parent));
	}

}
