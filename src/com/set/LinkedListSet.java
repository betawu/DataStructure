package com.set;

import com.linkedlist.LinkedList;

/**
 * 
 * @author beta
 *使用链表实现集合
 *
 */
public class LinkedListSet<E> implements Set<E>{

	private LinkedList list;
	
	public LinkedListSet() {
		this.list = new LinkedList<>();
	}
	
	@Override
	public void add(E e) {
		if(!list.contains(e)) {
			list.addFirst(e);
		}
	}

	@Override
	public void remove(E e) {
		list.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		LinkedListSet<Integer> set = new LinkedListSet<>();
		set.add(1);
		set.add(2);
		set.add(1);
		System.out.println(set.size());
		set.remove(2);
		System.out.println(set.size());
	}
}
