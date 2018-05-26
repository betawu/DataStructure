package com.queue;

import java.util.Arrays;
/**
 * 
 * @author beta
 *循环队列
 */
public class LoopQueue<E> implements Queue<E>{

	private E[] arr;
	private int front;
	private int tail;
	private int size;
	
	public LoopQueue() {
		arr = (E[])new Object[11];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public LoopQueue(int capacity) {
		arr = (E[])new Object[capacity+1];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	@Override
	public void enQueue(E e) {
		//如果容量已满扩容
		if((tail+1)%arr.length==front) {
			resize(2*(arr.length-1));
		}
		
		arr[tail]=e;
		tail = (tail+1)%arr.length;
		size++;
	}


	@Override
	public E deQueue() {
		if(isEmpty()) {
			throw new IllegalAccessError("循环队列为空");
		}
		E rs = arr[front];
		arr[front]=null;
		front = (front+1)%arr.length;
		size--;
		if((size/4)==arr.length/2&&arr.length/2!=0) {
			resize(arr.length/2);
		}
		
		return rs;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	@Override
	public int getCapacity() {
		return arr.length-1;
	}

	public E getFront() {
		return arr[front];
	}
	
	public int getSize() {
		return size;
	}
	
	//扩容
	private void resize(int newCapacity) {
		E[] newArr = (E[])new Object[newCapacity-1];
		for(int i=0;i<size;i++) {
			newArr[i] = arr[front];
			front = (front+1)%arr.length;
		}
		
		arr = newArr;
		tail=size;
		front = 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args) {
		LoopQueue<Integer> q = new LoopQueue<>();
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
