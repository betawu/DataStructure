package com.queue.priorityQueue;

import com.heap.MaxHeap;
import com.queue.Queue;

/**
 * 
 * @author beta
 *基于最大堆实现优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	public PriorityQueue() {
		h = new MaxHeap<>();
	}
	
	private MaxHeap<E> h;

	@Override
	public void enQueue(E e) {
		h.add(e);
	}

	@Override
	public E deQueue() {
		return h.extractMax();
	}
	
	@Override
	public boolean isEmpty() {
		return h.isEmpty();
	}

	@Override
	public int getCapacity() {
		return h.size();
	}
	
	public E getFront() {
		return h.findMax();
	}

}
