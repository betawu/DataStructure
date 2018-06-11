package com.segmentTree;

import java.util.Arrays;

/**
 * 
 * @author beta
 *线段树
 */
public class SegmentTree<E> {
	private E[] data;
	private E[] tree;
	private Merge<E> m;
	
	public SegmentTree(E[] arr,Merge<E> m) {
		
		this.m = m;
		
		data = (E[])new Object[arr.length];
		for(int i=0 ; i<arr.length ; i++) {
			data[i] = arr[i];
		}
		tree = (E[])new Object[arr.length*4];
		
		
		buildSegmentTree(0,0,arr.length-1);
	}
	
	//在索引为index的地方创建l到r的线段树
	private void buildSegmentTree(int index, int l, int r) {
		if(l == r) {
			tree[index] = data[l];
			return;
		}
		
		//防止数据溢出
		int mid = l+(r-l)/2;
		
		//递归创建线段树
		buildSegmentTree(getLeftChild(index), l, mid);
		buildSegmentTree(getRightChild(index), mid+1,r);
		
		tree[index] = m.merge(tree[2*index+1], tree[2*index+2]);
	}

	public E get(int index) {
		if(index<0||index>=data.length) {
			throw new IllegalAccessError("索引越界");
		}
		return data[index];
	}
	
	public int getSize() {
		return data.length;
	}
	
	public int getLeftChild(int i) {
		return i*2+1;
	}
	
	public int getRightChild(int i) {
		return i*2+2;
	}
	
	//查询线段树
	public E query(int lquery,int rquery) {
		return query(0,0,data.length-1,lquery,rquery);
	}

	//查询以index为根节点的l到r的线段树 中lquery到rquery的区间
	private E query(int index, int l, int r, int lquery, int rquery) {
		if(l==lquery&&r==rquery) {
			return tree[index];
		}
		
		int mid = l +(r-l)/2;
		int rc = getRightChild(index);
		int lc = getLeftChild(index);
		if(lquery>=mid+1) {
			return query(rc,mid+1,r,lquery,rquery);
		}else if(rquery <= mid) {
			return query(lc, l, mid, lquery, rquery);
		}
		
		E leftResult = query(lc, l, mid, lquery, mid);
		E rightResult = query(rc, mid+1, r, mid+1, rquery);
		return m.merge(leftResult, rightResult);
	}

	//更新线段树
	public void set(int index,E e) {
		data[index] = e;
		set(0,0,data.length-1,index,e);
	}
	
	
	private void set(int treeIndex, int l, int r, int index, E e) {
		if(l == r) {
			tree[treeIndex] = e;
			return;
		}
		
		int mid = l+(r-l)/2;
		int lc = getLeftChild(treeIndex);
		int rc = getRightChild(treeIndex);
		
		if(index>mid) {
			set(rc, mid+1, r, index, e);
		}else {
			set(lc, l, mid, index, e);
		}
		
		tree[treeIndex] = m.merge(tree[lc], tree[rc]);
	}

	@Override
	public String toString() {
		return Arrays.toString(tree);
	}

	public static void main(String[] args) {
		Integer[] arr= {-2,0,3,-5,2,-1,1,1};
		SegmentTree<Integer> st = new SegmentTree<>(arr,(a,b)->a+b);
//		Integer[] arr= {-2,0,3,-5,2,-1};
//		SegmentTree<Integer> st = new SegmentTree<>(arr,(a,b)->a+b);
		st.set(7, 0);
		System.out.println(st);
		System.out.println(st.query(1, 2));
	}
}
