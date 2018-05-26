package com.queue;

import com.linkedlist.LinkedList.Node;

public class LinkedListQueue<E> implements Queue<E>{

	//定义链表节点
	public class Node{
		public E data;
		public Node next;
		public Node(E data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		public Node(E data) {
			super();
			this.data=data;
		}
		public Node() {
			super();
		}
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
		
	private Node head;
	private Node tail;
	private int size;
	
	
	
	@Override
	public void enQueue(E e) {
		if(isEmpty()) {
			Node node = new Node(e);
			head = node;
			tail = node;
		}else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		
		size++;
	}

	@Override
	public E deQueue() {
		if(isEmpty()) {
			throw new IllegalAccessError("队列为空");
		}
		Node rsNode = head;
		head = head.next;
		rsNode.next = null;
		if(head==null) {
			tail = null;
		}
		size--;
		return rsNode.data;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int getCapacity() {
		return size;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		Node n = head;
		while(n!=null) {
			sb.append(n.data);
			sb.append("->");
			n = n.next;
		}
		sb.append("null");
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		LinkedListQueue<Integer> q = new LinkedListQueue<>();
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
