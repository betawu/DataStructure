package com.unionfind;

import java.util.Arrays;

/**
 * 
 * @author beta
 *并查集
 */
public class UnionFind2 implements UF{

	private int[] arr;
	
	public UnionFind2(int size) {
		this.arr = new int[size];
		for(int i=0;i<size;i++) {
			this.arr[i] = i;
		}
	}
	
	//获取元素的祖先节点
	private int find(int i) {
		if(i == arr[i]) {
			return i;
		}
		return find(arr[i]);
	}
	
	
	@Override
	public int getSize() {
		return arr.length;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if(qRoot == pRoot) {
			return;
		}
		arr[pRoot] = qRoot;
	}

	public static void main(String[] args) {
		UnionFind2 uf = new UnionFind2(10);
		System.out.println(Arrays.toString(uf.arr));
		uf.unionElements(0, 1);
		System.out.println(Arrays.toString(uf.arr));
		uf.unionElements(1, 2);
		System.out.println(Arrays.toString(uf.arr));
	}
}
