package com.set;

import com.binarysearchtree.BST;

/**
 * 
 * @author beta
 *基于二分搜索树实现集合
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{

	private BST<E> bst = new BST<>();
	
	@Override
	public void add(E e) {
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}

	@Override
	public int size() {
		return bst.size();
	}

	public static void main(String[] args) {
		BSTSet<Integer> set = new BSTSet<>();
		set.add(1);
		set.add(1);
		set.add(1);
		System.out.println(set.size());
	}
}
