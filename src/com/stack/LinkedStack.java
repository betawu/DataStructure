package com.stack;

import com.linkedlist.LinkedList;

/**
 * 
 * @author beta
 *链表实现栈
 */
public class LinkedStack<E> implements Stack<E>{

	private LinkedList<E> list;

	public LinkedStack() {
		list = new LinkedList<>();
	}
	
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public E peek() {
		return list.getFirst();
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.getSize()==0;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

	@Override
	public String toString() {
		return list.toString();
	}

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		for(int i=0;i<5;i++) {
			stack.push(i);
			System.out.println(stack);
		}
		
		stack.pop();
		System.out.println(stack);
	}
	

}
