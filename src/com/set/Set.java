package com.set;

public interface Set<E> {
	void add(E e);
	void remove(E e);
	boolean contains(E e);
	boolean isEmpty();
	int size();
}
