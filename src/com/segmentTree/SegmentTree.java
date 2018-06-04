package com.segmentTree;
/**
 * 
 * @author beta
 *线段树
 */
public class SegmentTree<E> {
	private E[] data;
	private E[] tree;
	
	public SegmentTree(E[] arr) {
		data = (E[])new Object[arr.length];
		for(int i=0 ; i<arr.length ; i++) {
			data[i] = arr[i];
		}
		tree = (E[])new Object[arr.length*4];
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
}
