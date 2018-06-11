package com.heap;

import java.util.Random;

import com.array.Array;

/**
 * 
 * @author beta
 *用数组实现二叉最大堆
 */
public class MaxHeap<E extends Comparable<E>> {
	private Array<E> arr;
	
	public MaxHeap() {
		arr = new Array<>();
	}
	
	public MaxHeap(int capacity) {
		arr = new Array<>(capacity);
	}
	
	//Heeapify操作将一个数组转换为最大堆
	//首先将数组看成是一个完全二叉树
	//然后从最后一个非叶子节点开始遍历到跟节点进行下沉操作
	public MaxHeap(E[] arr) {
		this.arr = new Array<>(arr);
		for(int i = getParent(arr.length-1);i>=0;i--) {
			siftDown(i);
		}
	}
	

	public boolean isEmpty() {
		return arr.isEmpty();
	}
	
	public int size() {
		return arr.getSize();
	}
	
	//获取数组表示的完全二叉树索引的父元素的索引
	public int getParent(int index) {
		if(index == 0) {
			throw new IllegalAccessError("根节点没有父元素");
		}
		return (index - 1)/2;
	}
	
	//获取数组表示的完全二叉树索引的左孩子元素的索引
	public int getLeftChild(int index) {
		return 2*index+1;
	}
	
	//获取数组表示的完全二叉树索引的右孩子元素的索引
	public int getRightChild(int index) {
		return 2*index+2;
	}
	
	public void add(E e) {
		arr.addLast(e);
		siftup(arr.getSize()-1);
	}

	//堆上浮操作
	private void siftup(int i) {
		while(i>0) {
			if(arr.get(i).compareTo(arr.get(getParent(i))) == 1) {
				arr.swap(i, getParent(i));
				i = getParent(i);
			}else {
				break;
			}
		}
	}
	
	public E findMax() {
		return arr.getFirst();
	}
	
	//取出堆中最大元素
	public E extractMax() {
		E e = arr.getFirst();
		arr.swap(0, arr.getSize()-1);
		arr.remove(arr.getSize()-1);
		siftDown(0);
		return e;
	}

	//堆元素下沉
	private void siftDown(int i) {
		while(getLeftChild(i)<arr.getSize()) {
			int l = getLeftChild(i);
			//判断是否有右孩子
			if(l+1<arr.getSize()) {
				int r = l+1;
				//判断右孩子和左孩子谁大
				if(arr.get(l).compareTo(arr.get(r)) == -1) {
					l = r;
				}
			}
			
			//将根节点与左右节点中最大的元素交换交换
			if(arr.get(i).compareTo(arr.get(l))==-1) {
				arr.swap(i, l);
				i = l;
			}else {
				break;
			}
		}
	}
	
	//将堆中最大元素替换
	public void replace(E e) {
		arr.set(0, e);
		siftDown(0);
	}
	
	public static void main(String[] args) {
		Integer[] arr = {133,22,1,43,435,676,234,25,657,234};
//		MaxHeap<Integer> h = new MaxHeap<>();
//		for(int i=0;i<10;i++) {
//			h.add(arr[i]);
//		}
		
		MaxHeap<Integer> h = new MaxHeap<>(arr);
//		h.replace(1000);
		while(!h.isEmpty()) {
			System.out.println(h.extractMax());
		}
	}
}
