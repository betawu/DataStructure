package com.stack;

/**
 * 
 * @author beta
 *栈的接口
 */
public interface Stack<E> {
	
	void push(E e);
	
	E pop();
	
	E peek();
	
	int getSize();
	
	boolean isEmpty();
	
	int getCapacity();
}
