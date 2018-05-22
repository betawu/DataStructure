package com.stack;

import com.array.Array;

/**
 * 
 * @author beta
 *用动态数组实现栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>{

	private Array<E> arr;
	
	public ArrayStack() {
		arr = new Array<>();
	}
	
	
	public ArrayStack(int capacity) {
		arr = new Array<>(capacity);
	}
	
	
	//入栈
	@Override
	public void push(E e) {
		arr.addLast(e);
	}

	//弹栈
	@Override
	public E pop() {
		return arr.remove(arr.getSize()-1);
	}

	@Override
	public E peek() {
		return arr.getLast();
	}

	@Override
	public int getSize() {
		return arr.getSize();
	}

	@Override
	public boolean isEmpty() {
		return arr.isEmpty();
	}

	@Override
	public int getCapacity() {
		return arr.getCapacity();
	}


	@Override
	public String toString() {
		return "ArrayStack [" + arr + "]";
	}

}
