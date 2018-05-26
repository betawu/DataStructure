package com.queue;

import com.array.Array;

/**
 * 
 * @author beta
 *队列
 */
public class ArrayQueue<E> implements Queue<E>{
	private Array<E> arr;
	
	public ArrayQueue() {
		arr = new Array<E>();
	}
	
	public ArrayQueue(int capacity) {
		arr = new Array<E>(capacity);
	}
	
	
	@Override
	public void enQueue(E e) {
		arr.addLast(e);
	}

	@Override
	public E deQueue() {
		return arr.remove(0);
	}
	
	@Override
	public int getCapacity() {
		return arr.getCapacity();
	}
	
	@Override
	public boolean isEmpty() {
		return arr.isEmpty();
	}
	
	
	
	@Override
	public String toString() {
		return arr.toString();
	}

	public static void main(String[] args) {
		ArrayQueue<Integer> q = new ArrayQueue<>();
		for(int i=0;i<10;i++) {
			q.enQueue(i);
			System.out.println(q);
			//每3个  索引从0开始所以等于2
			if(i%3==2) {
				q.deQueue();
				System.out.println(q);
			}
		}
	}

	
}
