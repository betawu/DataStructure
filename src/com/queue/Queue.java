package com.queue;

public interface Queue<E> {
	void enQueue(E e);
	
	E deQueue();
	
	boolean isEmpty();
	
	int getCapacity();
	

}
