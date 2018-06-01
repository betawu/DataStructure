package com.linkedlist;
/**
 * 
 * @author beta
 *链表
 */
public class LinkedList<E> {
	
	//带虚拟头节点的链表

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
	
	private Node dummyHead;
	private int size;
	
	public LinkedList() {
		dummyHead = new Node(null,null);
		size=0;
	}
	
	public void addFirst(E e) {
		add(0,e);
	}
	
	
	public void add(int index,E e) {
		if(index<0||index>size) {
			throw new IllegalAccessError("索引越界");
		}
		
		//找前一个节点  从虚拟节点开始遍历
		Node prev = dummyHead;
		for(int i=0;i<index;i++) {
			prev = prev.next;
		}
		
//		Node node = new Node(e);
//		node.next=prev.next;
//		prev.next=node.next;
		prev.next = new Node(e,prev.next);
		size++;
	}
	
	public void addLast(E e) {
		add(size,e);
	}
	
	//找指定索引的节点
	//找当前节点  从虚拟节点后一个节点开始遍历
	public E get(int index) {
		if(index<0||index>=size) {
			throw new IllegalAccessError("索引越界");
		}
		
		Node cur = dummyHead.next;
		for(int i =0;i<index;i++) {
			cur=cur.next;
		}
		return cur.data;
		
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size-1);
	}
	
	public void set(int index,E e) {
		Node cur = dummyHead.next;
		for(int i=0;i<index;i++) {
			cur=cur.next;
		}
		cur.data=e;
	}
	
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while(cur!=null) {
			if(cur.data.equals(e)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node cur=dummyHead.next;cur!=null;cur=cur.next) {
			sb.append(cur.data).append("->");
		}
		sb.append("null");
		return sb.toString();
		
	}
	
	
	public E remove(int index) {
		if(index<0||index>=size) {
			throw new IllegalAccessError("索引越界");
		}
		
		Node pre = dummyHead;
		for(int i =0 ;i<index;i++) {
			pre=pre.next;
		}
		
		Node remNode = pre.next;
		pre.next=remNode.next;
		remNode.next=null;
		size--;
		return (E) remNode;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	
	
	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<10;i++) {
			list.addFirst(i);
			System.out.println(list);
		}
		
		list.add(2, 666);
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void remove(E e) {
		Node pre = dummyHead;
		while(pre.next != null) {
			if(pre.next.data.equals(e)) {
				Node node = pre.next;
				pre.next = node.next;
				node = null;
				size--;
			}
			pre = pre.next;
		}
	}
	
	//找当前节点  从虚拟节点的下一个节点开始
	
	
//	//定义链表节点
//	public class Node{
//		public E data;
//		public Node next;
//		public Node(E data, Node next) {
//			super();
//			this.data = data;
//			this.next = next;
//		}
//		public Node(E data) {
//			super();
//			this.data=data;
//		}
//		public Node() {
//			super();
//		}
//		@Override
//		public String toString() {
//			return data.toString();
//		}
//	}
//	
//	private Node head;
//	private int size;
//	
//	
//	public void addFirst(E e) {
////		Node node = new Node(e);
////		node.next=head.next;
////		head = node;
//		head = new Node(e,head.next);
//		
//		size++;
//	}
//	
//	public void add(int index,E e) {
//		if(index<0||index>size) {
//			throw new IllegalAccessError("索引越界");
//		}
//		
//		Node prev = head;
//		for(int i=0;i<index-1;i++) {
//			prev = prev.next;
//		}
//		
////		Node node = new Node(e);
////		node.next=prev.next;
////		prev.next=node.next;
//		prev = new Node(e,prev.next);
//		size++;
//	}
//	
//	public void addLast(E e) {
//		add(size,e);
//	}
}
