package com.unionfind;

import java.util.Arrays;

/**
 * 
 * @author beta
 *并查集 v1.0
 */
public class UnionFind1 implements UF{

	private int[] id;
	
	public UnionFind1(int size) {
		id = new int[size];
		for(int i=0;i<id.length;i++) {
			id[i] = i;
		}
	}
	
	
	//查找p元素所属的集合
	private int find(int p) {
		return id[p];
	}
	
	
	@Override
	public int getSize() {
		return id.length;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	//将p所属的集合所有元素都与q合并
	@Override
	public void unionElements(int p, int q) {
		int pv = find(p); 
		int qv = find(q); 
		for(int i=0;i<id.length;i++) {
			if(id[i] == pv) {
				id[i] = qv;
 			}
		}
	}
	
	
	public static void main(String[] args) {
		UnionFind1 uf = new UnionFind1(10);
		System.out.println(Arrays.toString(uf.id));
		uf.unionElements(0, 1);
		uf.unionElements(1, 2);
		System.out.println(Arrays.toString(uf.id));
	}
}
